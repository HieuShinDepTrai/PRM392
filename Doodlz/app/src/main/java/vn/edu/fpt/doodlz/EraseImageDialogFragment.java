// EraseImageDialogFragment.java
// Allows user to erase image
package vn.edu.fpt.doodlz;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

//class for the Select Color dialog   
public class EraseImageDialogFragment extends DialogFragment
{
   // create an AlertDialog and return it
   @Override
   public Dialog onCreateDialog(Bundle bundle)
   {
      AlertDialog.Builder builder = 
         new AlertDialog.Builder(getActivity());
      
      // set the AlertDialog's message 
      builder.setMessage(R.string.message_erase);
      builder.setCancelable(false);
    
      // add Erase Button
      builder.setPositiveButton(R.string.button_erase,
         new DialogInterface.OnClickListener() 
         {
            public void onClick(DialogInterface dialog, int id) 
            {
               getDoodleFragment().getDoodleView().clear(); // clear image
            } 
         } 
      ); // end call to setPositiveButton
   
      // add Cancel Button
      builder.setNegativeButton(R.string.button_cancel, null);

      return builder.create(); // return dialog
   } // end method onCreateDialog   

   // gets a reference to the DoodleFragment
   private DoodleFragment getDoodleFragment()
   {
      return (DoodleFragment) getFragmentManager().findFragmentById(
         R.id.doodleFragment);
   }

   // tell DoodleFragment that dialog is now displayed
   @Override
   public void onAttach(Activity activity)
   {
      super.onAttach(activity);
      DoodleFragment fragment = getDoodleFragment();
      
      if (fragment != null)
         fragment.setDialogOnScreen(true);
   }

   // tell DoodleFragment that dialog is no longer displayed
   @Override
   public void onDetach()
   {
      super.onDetach();
      DoodleFragment fragment = getDoodleFragment();
      
      if (fragment != null)
         fragment.setDialogOnScreen(false);
   }         
} // end class EraseImageDialogFragment

/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               * 
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     * 
 * best efforts in preparing the book. These efforts include the          * 
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       * 
 * no warranty of any kind, expressed or implied, with regard to these    * 
 * programs or to the documentation contained in these books. The authors * 
 * and publisher shall not be liable in any event for incidental or       * 
 * consequential damages in connection with, or arising out of, the       * 
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************/
