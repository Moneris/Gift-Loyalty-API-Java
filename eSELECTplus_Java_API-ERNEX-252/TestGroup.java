import java.io.*;
import java.util.*;
import java.net.*;

import JavaAPIErnex.*;


public class TestGroup
{
  public static void main(String args[]) throws IOException
  {

/********************** Request Variables ****************************/

        String host = "esqa.moneris.com";
        String store_id = args[0];
        String api_token = args[1];
        String order_id = args[2];
        String txn_number = args[3];
        String group_ref_num = args[4];
        String group_type = args[5];
        
        Group g = new Group (order_id, txn_number, group_ref_num, group_type);

        ErnexHttpsPostRequest mpgReq =
            new ErnexHttpsPostRequest(host, store_id, api_token, g);

        try
        {
            ErnexReceipt receipt = mpgReq.getReceipt();
            
            System.out.println("ReceiptId = " + receipt.getReceiptId());
            System.out.println("ResponseCode = " + receipt.getResponseCode());
            System.out.println("TransTime = " + receipt.getTransTime());
            System.out.println("TransDate = " + receipt.getTransDate());
            System.out.println("TransType = " + receipt.getTransType());
            System.out.println("Complete = " + receipt.getComplete());
            System.out.println("Message = " + receipt.getMessage());
            System.out.println("TxnNumber = " + receipt.getTxnNumber());
            System.out.println("TimedOut = " + receipt.getTimedOut());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
  }

} // end TestGroup Class