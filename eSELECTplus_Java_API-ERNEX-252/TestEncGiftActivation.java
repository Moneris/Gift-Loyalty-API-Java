import java.io.*;
import java.util.*;
import java.net.*;

import JavaAPIErnex.*;


public class TestEncGiftActivation
{
  public static void main(String args[]) throws IOException
  {

/********************** Request Variables ****************************/

        String host = "esqa.moneris.com";
        String store_id = args[0];
        String api_token = args[1];
        String order_id = args[2];
        String cust_id = args[3]; //optional
        String enc_track2 = args[4];

        if (enc_track2.contains("" +(char)0x1D))
        {
        	enc_track2 = enc_track2.substring(enc_track2.indexOf((char)0x1D) + 1);
        }
        if (enc_track2.contains("" +(char)0x1C))
        {
        	enc_track2 = enc_track2.substring(0, enc_track2.indexOf((char)0x1C));
        }
        
        String initial_amount = args[5];
        String info = args[6];
        String language_code = args[7];
        String cvd_value = args[8];
        
        EncErnexGiftActivation ega = new EncErnexGiftActivation (order_id, cust_id, initial_amount, enc_track2,
        		cvd_value, language_code, info);

        ErnexHttpsPostRequest mpgReq =
            new ErnexHttpsPostRequest(host, store_id, api_token, ega, false);

        try
        {
            ErnexReceipt receipt = mpgReq.getReceipt();
            Card [] cards = receipt.getCards();
            
            System.out.println("ReceiptId = " + receipt.getReceiptId());
            System.out.println("ResponseCode = " + receipt.getResponseCode());
            System.out.println("HostReferenceNum = " + receipt.getHostReferenceNum());
            System.out.println("TransTime = " + receipt.getTransTime());
            System.out.println("TransDate = " + receipt.getTransDate());
            System.out.println("TransType = " + receipt.getTransType());
            System.out.println("Message = " + receipt.getMessage());
            System.out.println("TransCardCode = " + receipt.getTransCardCode());
            System.out.println("TransCardType = " + receipt.getTransCardType());
            System.out.println("TxnNumber = " + receipt.getTxnNumber());
            System.out.println("TimedOut = " + receipt.getTimedOut());
            System.out.println("HostTotals = " + receipt.getHostTotals());
            System.out.println("DisplayText = " + receipt.getDisplayText());
            System.out.println("ReceiptText = " + receipt.getReceiptText());
            System.out.println("CardHolderName = " + receipt.getCardHolderName());
            System.out.println("VoucherType = " + receipt.getVoucherType());
            System.out.println("VoucherText = " + receipt.getVoucherText());
            System.out.println("InitialAmount = " + receipt.getInitialAmount());
            System.out.println("InitialBalance = " + receipt.getInitialBalance());
            System.out.println("BatchNo = " + receipt.getBatchNo());
            System.out.println("CurrentBalance = " + receipt.getCurrentBalance());
            System.out.println("Benefit = " + receipt.getBenefit());
            System.out.println("Language = " + receipt.getLanguage());
            System.out.println("ErrorCode = " + receipt.getErrorCode());
            System.out.println("ErrorMessage = " + receipt.getErrorMessage());
            System.out.println("ActivationCharge = " + receipt.getActivationCharge());
            System.out.println("RemainingBalance = " + receipt.getRemainingBalance());
            System.out.println("CardStatus = " + receipt.getCardStatus());
            
            
            for (int i = 0;i<cards.length;i++)
            {
            	System.out.println("\nCardCode = " + cards[i].getCardCode() + "\n");
            	System.out.println("CardCardType = " + cards[i].getCardCardType());
            	System.out.println("CheckMod10 = " + cards[i].getCheckMod10());
            	System.out.println("CheckLanguage = " + cards[i].getCheckLanguage());
            	System.out.println("CVCPrompt = " + cards[i].getCVCPrompt());
            	System.out.println("InfoPrompt = " + cards[i].getInfoPrompt());
            	System.out.println("InitialAmountPrompt = " + cards[i].getInitialAmountPrompt());
            	System.out.println("RefundAllowed = " + cards[i].getRefundAllowed());
            	System.out.println("CardLengthMinimum = " + cards[i].getCardLengthMinimum());
            	System.out.println("CardLengthMaximum = " + cards[i].getCardLengthMaximum());
            	System.out.println("LowBIN1 = " + cards[i].getLowBIN1());
            	System.out.println("HighBIN1 = " + cards[i].getHighBIN1());
            	System.out.println("LowBIN2 = " + cards[i].getLowBIN2());
            	System.out.println("HighBIN2 = " + cards[i].getHighBIN2());
            	System.out.println("LowBIN3 = " + cards[i].getLowBIN3());
            	System.out.println("HighBIN3 = " + cards[i].getHighBIN3());
            	System.out.println("LowBIN4 = " + cards[i].getLowBIN4());
            	System.out.println("HighBIN4 = " + cards[i].getHighBIN4());
            	
            	Text [] texts = cards[i].getTexts();
            
            	for (int j = 0;j<texts.length;j++)
            	{
            		System.out.println("\nRecordType = " + texts[j].getRecordType() +"\n");
            		System.out.println("CardDescription = " + texts[j].getCardDescription());
            		System.out.println("InfoPromptText = " + texts[j].getInfoPromptText());
            	}
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
  }

} // end TestActivation Class