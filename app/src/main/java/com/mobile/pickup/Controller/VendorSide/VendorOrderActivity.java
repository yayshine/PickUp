package com.mobile.pickup.Controller.VendorSide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.pickup.Model.Order;
import com.mobile.pickup.OrderManager;
import com.mobile.pickup.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendorOrderActivity extends AppCompatActivity
{

    private List<Order> orders = new ArrayList<CustomerOrder>();
    ArrayAdapter<Order> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_order);

        //referencing activity_vendor_order.xml; write code here
        populateOrderList();
        createOrderObject();
    }

    //creating the ListView of CustomerOrder objects using array Adapter
    public void createOrderObject()
    {
        adapter1 = new MyListAdapter();          //create array adaptor
        ListView orderList = (ListView) findViewById(R.id.order_list_view);  //create the list object
        orderList.setAdapter(adapter1);                                      //use List object to set

    }


    //for now, ther are just arbitrary values to place into Order List
    private void populateOrderList()
    {
//        //later populate using OrderManager.java
//        HashMap<String, Integer> sotired = new HashMap<String,Integer>();
//        sotired.put("ham", 3);
//        sotired.put("dirt", 4);
//        sotired.put("lol", 1);
//        CustomerOrder order1 = new CustomerOrder("bob1 (name)",R.drawable.done_button,false,sotired);
//        orders.add(order1);
//
//        HashMap<String, Integer> imsick = new HashMap<String,Integer>();
//        imsick.put("ham", 3);
//        imsick.put("dirt", 2);
//        imsick.put("elephant", 9);
//        CustomerOrder order2 = new CustomerOrder("bob2",R.drawable.done_button,false,imsick);
//        orders.add(order2);
//
//        orders.add(order2);orders.add(order2);
//        orders.add(order2);orders.add(order2);orders.add(order2);orders.add(order2);
        orders = OrderManager;
    }



    //subclass MyListAdapter
    private class MyListAdapter extends ArrayAdapter<CustomerOrder>
    {
       public MyListAdapter()
       {
           super(VendorOrderActivity.this, R.layout.order_object_view, orders);
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
                itemView = getLayoutInflater().inflate(R.layout.order_object_view, parent, false);
            }
            //get CustomerOrder from ArrayLIst according to position
            CustomerOrder currentOrder = orders.get(position);
            ImageButton doneButton = (ImageButton) itemView.findViewById(R.id.done_button);

            //load current Order object's image into ImageButton; set listener
            doneButton.setImageResource(currentOrder.getimgButtonID());
            MyOnClickListener listener = new MyOnClickListener(position);
            doneButton.setOnClickListener(listener);

            //sets crder# and customer name
            String orderTitle = "Order#"+(int)(position+1) + ": " + orders.get(position).getcustomerName();
            TextView customerName = (TextView) itemView.findViewById(R.id.customer_name);
            customerName.setText(orderTitle);

            //sets customer's foodList from the HashMap's keySet
            TextView foodList = (TextView) itemView.findViewById(R.id.food_list);
            foodList.setText(orders.get(position).getFoodList());

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
            //use Toast for debugging
            //int printPos = pos+1;
            String removeMessage = "Finished Order#" + (int)(pos+1) + ". Removed from list!";
            Toast.makeText(VendorOrderActivity.this, removeMessage,Toast.LENGTH_LONG).show();
            adapter1.remove(orders.get(pos));
            adapter1.notifyDataSetChanged();
        }
    }

}