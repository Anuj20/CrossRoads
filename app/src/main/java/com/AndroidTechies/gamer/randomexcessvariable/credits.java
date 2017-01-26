package com.AndroidTechies.gamer.randomexcessvariable;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.AndroidTechies.gamer.randomexcessvariable.cheats.intro_cheats;
import com.AndroidTechies.gamer.randomexcessvariable.honest_methods.intro_honest;
import com.AndroidTechies.gamer.randomexcessvariable.overflow.App_info;
import com.AndroidTechies.gamer.randomexcessvariable.overflow.contact_us;

public class credits extends AppCompatActivity {

    TextView  texttitle;
    TextView names;
    TextView mentor;
    TextView mentorname;
    TextView appreciation;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        View backgroundimage = findViewById(R.id.background);
        Drawable background = backgroundimage.getBackground();
        background.setAlpha(70);

        texttitle= (TextView)this. findViewById(R.id.textcredit_title);
        names= (TextView)this. findViewById(R.id.textcredit_names);
        mentor= (TextView) this.findViewById(R.id.textcredits_mentor);
        mentorname= (TextView)this. findViewById(R.id.textcredits_mentorname);
        appreciation= (TextView) this.findViewById(R.id.textcredits_apreciation);
        names.startAnimation(
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade));
        mentorname.startAnimation(
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade2)
        );
    }

    //showing overflow menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     * <p/>
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    // customization of overflow menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //this handles the action bar item clicks.

        int id=item.getItemId();

        if(id==R.id.whychoosetheeasyroad) {
            Intent easyroad = new Intent(this, intro_cheats.class);
            startActivity(easyroad);
            return true;
        }

        if(id==R.id.whychoosetheroadlesstaken) {
            Intent roadlesstaken = new Intent(this, intro_honest.class);
            startActivity(roadlesstaken);
            return true;
        }

        if(id==R.id.Feedback) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"heathc2098@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Name");
            i.putExtra(Intent.EXTRA_CC,"college&Branch");
            i.putExtra(Intent.EXTRA_TEXT   , "Feedback");
            try {
                startActivity(Intent.createChooser(i, "Send..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
            return true;}

        if (id == R.id.Submit) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"heathc2098@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Cheat Name");
            i.putExtra(Intent.EXTRA_TEXT   , "Provide the description of the cheat and also mention your name, branch, year and phone number(optional) at the end");
            try {
                startActivity(Intent.createChooser(i, "Send..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
            return true;}

        if (id == R.id.App_info) {
            Intent app = new Intent(this, App_info.class);
            startActivity(app);
            return true;
        }
        if (id == R.id.credits) {
            Intent credits = new Intent(this, credits.class);
            startActivity(credits);
            return true;
        }


        if (id == R.id.Contact) {
            Intent app = new Intent(this, contact_us.class);
            startActivity(app);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}