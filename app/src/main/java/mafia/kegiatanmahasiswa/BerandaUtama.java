package mafia.kegiatanmahasiswa;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.nononsenseapps.filepicker.FilePickerActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class BerandaUtama extends ActionBarActivity{

    private static int FILE_CODE = 1;
    private CharSequence mTitle;

    Drawer result;
    SessionManager session;

    EditText txtTanggal, txtWaktu , txtProposal;

    // Variable for storing current date and time
    private int mYear, mMonth, mDay, mHour, mMinute;

    String url="http://colletivita.hol.es/images/foto_profil/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_utama);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        session = new SessionManager(this);
        session.checkLogin();
        // get user data from session
        HashMap<String, String> user = session.getUserDetails();
        // name
        String name = user.get(SessionManager.KEY_NAME);
        // email
        String nim = user.get(SessionManager.KEY_NIM);

        String profpic = user.get(SessionManager.KEY_PROFPIC);


        mTitle = getString(R.string.title_section0);
        openFragment(new Beranda());
        restoreActionBar();

        DrawerImageLoader.init(new DrawerImageLoader.IDrawerImageLoader() {
                                   @Override
                                   public void set(ImageView imageView, Uri uri, Drawable placeholder) {
                                       Picasso.with(imageView.getContext()).load(uri).placeholder(placeholder).into(imageView);
                                   }

                                   @Override
                                   public void cancel(ImageView imageView) {
                                       Picasso.with(imageView.getContext()).cancelRequest(imageView);
                                   }

                                   @Override
                                   public Drawable placeholder(Context ctx) {
                                       return null;
                                   }
                               }
        );


        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.ColorPrimary)
                .withSelectionListEnabledForSingleProfile(false)
                .addProfiles(
                        new ProfileDrawerItem().withName(nim).withEmail(name).withIcon(Uri.parse(url + profpic)))
                .build();



        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        new SecondaryDrawerItem()
                                .withName(R.string.title_section0)
                                .withIdentifier(1)
                                .withSelectedTextColorRes(R.color.ColorPrimary)
                                .withIcon(getResources().getDrawable(R.drawable.ic_drawer)),
                        new SecondaryDrawerItem()
                                .withName(R.string.title_section)
                                .withIdentifier(2)
                                .withSelectedTextColorRes(R.color.ColorPrimary)
                                .withIcon(getResources().getDrawable(R.drawable.ic_drawer)),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName(R.string.title_section1)
                                .withIdentifier(3)
                                .withSelectedTextColorRes(R.color.ColorPrimary)
                                .withIcon(getResources().getDrawable(R.drawable.posting_48)),
                        new SecondaryDrawerItem()
                                .withName(R.string.title_section2)
                                .withIdentifier(4)
                                .withSelectedTextColorRes(R.color.ColorPrimary)
                                .withIcon(getResources().getDrawable(R.drawable.postinganku_48)),
                        new SecondaryDrawerItem()
                                .withName(R.string.title_section3)
                                .withIdentifier(5)
                                .withSelectedTextColorRes(R.color.ColorPrimary)
                                .withIcon(getResources().getDrawable(R.drawable.password_48)),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName(R.string.title_section4)
                                .withIdentifier(6)
                                .withSelectedTextColorRes(R.color.ColorPrimary)
                                .withIcon(getResources().getDrawable(R.drawable.keluar_48))
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (drawerItem.getIdentifier()) {
                            case 1:
                                mTitle = getString(R.string.title_section0);
                                openFragment(new Beranda());
                                break;
                            case 2:
                                mTitle = getString(R.string.title_section);
                                openFragment(new PostinganPersonal());
                                break;
                            case 3:
                                mTitle = getString(R.string.title_section1);
                                openFragment(new PostingOrganisasi());
                                break;
                            case 4:
                                mTitle = getString(R.string.title_section2);
                                openFragment(new Postinganku());
                                break;
                            case 5:
                                mTitle = getString(R.string.title_section3);
                                openFragment(new UbahPassword());
                                break;
                            case 6:
                                mTitle = getString(R.string.title_section4);
                                openFragment(new Logout());
                                break;
                        }
                        restoreActionBar();
                        return false;
                    }
                })
                .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);

    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private void openFragment(final Fragment fragment) {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    public void hideSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)  getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    public void openCalendar(View view) {

            txtTanggal = (EditText) findViewById(R.id.txt_tanggal_acara);

            // Process to get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // Display Selected date in textbox
                            txtTanggal.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            dpd.show();
        }

    public void openTime(View view) {

        txtWaktu = (EditText) findViewById(R.id.txt_waktu_acara);
        // Process to get Current Date
        // Process to get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog tpd;
        tpd = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        // Display Selected time in textbox
                        txtWaktu.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        tpd.show();
    }

    public void openDir(View view)
    {
        Intent i = new Intent(this, FilePickerActivity.class);
        // This works if you defined the intent filter
        // Intent i = new Intent(Intent.ACTION_GET_CONTENT);

        // Set these depending on your use case. These are the defaults.
        i.putExtra(FilePickerActivity.EXTRA_ALLOW_MULTIPLE, false);
        i.putExtra(FilePickerActivity.EXTRA_ALLOW_CREATE_DIR, false);
        i.putExtra(FilePickerActivity.EXTRA_MODE, FilePickerActivity.MODE_FILE);

        // Configure initial directory by specifying a String.
        // You could specify a String like "/storage/emulated/0/", but that can
        // dangerous. Always use Android's API calls to get paths to the SD-card or
        // internal memory.
        i.putExtra(FilePickerActivity.EXTRA_START_PATH, Environment.getExternalStorageDirectory().getPath());

        startActivityForResult(i, FILE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        txtProposal = (EditText) findViewById(R.id.txt_proposal);
        if (requestCode == FILE_CODE && resultCode == Activity.RESULT_OK) {
            if (data.getBooleanExtra(FilePickerActivity.EXTRA_ALLOW_MULTIPLE, false)) {
                // For JellyBean and above
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    ClipData clip = data.getClipData();

                    if (clip != null) {
                        for (int i = 0; i < clip.getItemCount(); i++) {
                            Uri uri = clip.getItemAt(i).getUri();
                            // Do something with the URI
                        }

                    }
                }

            } else {
                Uri uri = data.getData();
                // Do something with the URI
                txtProposal.setText(uri.getPath());
            }
        }
    }

}
