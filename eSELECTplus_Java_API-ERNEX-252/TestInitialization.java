import java.io.*;
import java.util.*;
import java.net.*;

import JavaAPIErnex.*;


public class TestInitialization
{
  public static void main(String args[]) throws IOException
  {

/********************** Request Variables ****************************/

        String host = "esqa.moneris.com";
        String store_id = "monca00001";
        String api_token = "giftguy";

        String ecr_number = "00035540";

        ErnexInitialization ei = new ErnexInitialization (ecr_number);

        ErnexHttpsPostRequest mpgReq =
            new ErnexHttpsPostRequest(host, store_id, api_token, ei);

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

} // end TestInitialization Class