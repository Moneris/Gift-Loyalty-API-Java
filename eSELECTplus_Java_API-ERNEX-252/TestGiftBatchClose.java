import java.io.*;
import java.util.*;
import java.net.*;

import JavaAPIErnex.*;


public class TestGiftBatchClose
{
  public static void main(String args[]) throws IOException
  {

/********************** Request Variables ****************************/

        String host = "esqa.moneris.com";
        String store_id = args[1];
        String api_token = args[2];

        String ecr_number = args[3];

        ErnexBatchClose ebc = new ErnexBatchClose (ecr_number);

        ErnexHttpsPostRequest mpgReq =
            new ErnexHttpsPostRequest(host, store_id, api_token, ebc);

        try
        {
            ErnexReceipt receipt = mpgReq.getReceipt();
            Terminal [] terminals = receipt.getTerminals();
            System.out.println("ReceiptId = " + receipt.getReceiptId());
            
            if (receipt.getReceiptId().equals("Global Error Receipt"))
            {
            	System.out.println("TransType = " + receipt.getTransType());
            	System.out.println("HostReferenceNum = " + receipt.getReferenceNum());
            	System.out.println("ResponseCode = " + receipt.getResponseCode());
            	System.out.println("Message = " + receipt.getMessage());
            	System.out.println("Complete = " + receipt.getComplete());
            	System.out.println("TransDate = " + receipt.getTransDate());
            	System.out.println("TransTime = " + receipt.getTransTime());
            	System.out.println("TimedOut = " + receipt.getTimedOut());
            }
            
            else
            {
            	 for (int i = 0;i<terminals.length;i++)
                 {
            		 System.out.println("TerminalId = " + terminals[i].getTerminalId());
            		 System.out.println("Closed = " + terminals[i].getClosed());
            		 
            		 BatchInfo [] batchinfos = terminals[i].getBatchInfos();
            		 
            		 for (int j = 0;j<batchinfos.length;j++)
            		 {
            			 System.out.println("\nCardCode = " + batchinfos[j].getEcrCardCode() + "\n");
            			 System.out.println("PurchaseCount = " + batchinfos[j].getPurchaseCount());
            			 System.out.println("PurchaseTotal = " + batchinfos[j].getPurchaseTotal());
            			 System.out.println("PurchaseBenefitTotal = " + batchinfos[j].getPurchaseBenefitTotal());
            			 System.out.println("RefundCount = " + batchinfos[j].getRefundCount());
            			 System.out.println("RefundTotal = " + batchinfos[j].getRefundTotal());
            			 System.out.println("RefundBenefitTotal = " + batchinfos[j].getRefundBenefitTotal());
            			 System.out.println("ActivationCount = " + batchinfos[j].getActivationCount());
            			 System.out.println("ActivationTotal = " + batchinfos[j].getActivationTotal());
            			 System.out.println("CorrectionCount = " + batchinfos[j].getCorrectionCount());
            			 System.out.println("CorrectionTotal = " + batchinfos[j].getCorrectionTotal());
            		 }
                 }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
  }

} // end TestBachClose 