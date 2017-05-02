package com.mobile.pickup.Controller.VendorSide;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.mobile.pickup.Model.VendorSide.OrderListItem;
import com.mobile.pickup.OrderManager;
import com.mobile.pickup.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderListActivity extends Activity
{

    private List<OrderListItem> orders = new ArrayList<OrderListItem>();
    ArrayAdapter<OrderListItem> adapter1;
    OrderManager manager;
    String vendorID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_v_order_list);

        vendorID = "-Kfz4012r7qbR08higRA";
        //referencing activity_v_order_list.xml; write code here
        populateOrderList();
        createOrderObject();
    }

    //creating the ListView of CustomerOrder objects using array Adapter
    public void createOrderObject()
    {
        adapter1 = new MyListAdapter();          //create array adaptor
        ListView orderList = (ListView) findViewById(R.id.order_list_view);  //create the list object
        orderList.setAdapter(adapter1);                                      //use List object to set


        //listen for swipes to delete
        SwipeDismissListViewTouchListener touchListener = new SwipeDismissListViewTouchListener
                (orderList, new SwipeDismissListViewTouchListener.DismissCallbacks()
                {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            //delete on dismiss
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions)
                                {
                                    String removeMessage = "Finished Order#" + (int)(position+1) + ". Removed from list!";
                                    Toast.makeText(OrderListActivity.this, removeMessage,Toast.LENGTH_LONG).show();
                                    orders.remove(position);
                                    adapter1.notifyDataSetChanged();
                                }
                            }
                });
        orderList.setOnTouchListener(touchListener);

    }


    //for now, ther are just arbitrary values to place into Order List
    private void populateOrderList()
    {
        //later populate using OrderManager.java
        /*HashMap<String, Integer> sotired = new HashMap<String,Integer>();
        sotired.put("ham", 3);
        sotired.put("dirt", 4);
        sotired.put("lol", 1);
        OrderListItem order1 = new OrderListItem("order1","bob A",sotired);
        orders.add(order1);

        HashMap<String, Integer> imsick = new HashMap<String,Integer>();
        imsick.put("ham", 3);
        imsick.put("dirt", 2);
        imsick.put("elephant", 9);
        OrderListItem order2 = new OrderListItem("order2","bob B ",imsick);
        orders.add(order2);

        orders.add(order2);orders.add(order2);
        orders.add(order2);orders.add(order2);orders.add(order2);orders.add(order2);*/

        manager = new OrderManager();
        orders = manager.getAllActiveOrders(vendorID);

        //when there is a change in the local adapter1, call notifyDataSetChanged to change it in Firebase
        manager.setOnOrdersReadListener(new OrderManager.OnOrdersReadListener() {
        @Override
        public void onFinish() {
            adapter1.notifyDataSetChanged();
        }
    });
    }



    //subclass MyListAdapter
    private class MyListAdapter extends ArrayAdapter<OrderListItem>
    {
       public MyListAdapter()
       {
           super(OrderListActivity.this, R.layout.view_order_list_item, orders);
       }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View itemView = convertView;

            if (itemView==null)     //if no view, make one using order_object_view
            {
                //if no order View, then "inflate" layout; create layout for us
                //working on the parent view
                //do not attach to root -- false
                itemView = getLayoutInflater().inflate(R.layout.view_order_list_item, parent, false);

            }
            //get CustomerOrder from ArrayLIst according to position
            OrderListItem currentOrder = orders.get(position);


            //load current Order object's image into ImageButton; set listener
            /*
            ImageButton doneButton = (ImageButton) itemView.findViewById(R.id.done_button);
            doneButton.setImageResource(R.drawable.done_button);
            MyOnClickListener listener = new MyOnClickListener(position);
            doneButton.setOnClickListener(listener);
            */

            //sets crder# and customer name
            String orderTitle = "Order#"+(int)(position+1) + ": " + orders.get(position).getCustomerName();
            TextView customerName = (TextView) itemView.findViewById(R.id.customer_name);
            customerName.setText(orderTitle);

            //sets customer's foodList from the HashMap's keySet
            TextView foodList = (TextView) itemView.findViewById(R.id.food_list);
            //iterate through hashmap to get food list for each customer

            String listString = "";
            for (String i : currentOrder.getFoodItemNameQuantMap().keySet())
            {
                listString = listString + i +  " x"+currentOrder.getFoodItemNameQuantMap().get(i)+ "\n";
            }
            foodList.setText(listString);

            return itemView;
        }
    }

    //when clicked ready, remove from list
    public class MyOnClickListener implements View.OnClickListener
    {
        int pos = 0;
        MyOnClickListener(int position)
        {
            pos = position;
        }

        //when ImageButton (ready) is clicked, remove the Order
        public void onClick(View v)
        {
            //changed order Boolean to true (meaning that order was completed)
            manager.updateIsReady(orders.get(pos).getOrderID(),true);

            //removes from list locally and prints out removal message
            String removeMessage = "Finished Order#" + (int)(pos+1) + ". Removed from list!";
            Toast.makeText(OrderListActivity.this, removeMessage,Toast.LENGTH_LONG).show();
            adapter1.remove(orders.get(pos));
            adapter1.notifyDataSetChanged();
        }
    }

}