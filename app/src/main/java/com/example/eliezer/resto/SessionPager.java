package com.example.eliezer.resto;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SessionPager extends FragmentPagerAdapter {
    public SessionPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;

            case 1 :
                TableFragment tableFragment = new TableFragment();
                return tableFragment;

                default:
                    return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       switch (position){
           case 0:
               return "Home";
           case 1:
               return "Table";
               default:
                   return null;
       }
    }


    /*

SteppersView.Config steppersViewConfig = new SteppersView.Config();
        steppersViewConfig.setOnFinishAction(new OnFinishAction() {
            @Override
            public void onFinish() {
                //Action on last step finish button
            }
        });

        steppersViewConfig.setOnCancelAction(new OnCancelAction() {
            @Override
            public void onCancel() {
                //Action when click cancel button
            }
        });

        steppersViewConfig.setOnChangeStepAction(new OnChangeStepAction() {
            @Override
            public void onChangeStep(int position, SteppersItem activeStep) {

            }
        });

        //Setup support fragment manager for fragments in steps
        steppersViewConfig.setFragmentManager(getSupportFragmentManager());

        ArrayList<SteppersItem> steps = new ArrayList <>();
        SteppersItem stepFirst = new SteppersItem();
        stepFirst.setLabel("Restaurant Name");
        stepFirst.setSubLabel("Order food online before reaching the restaurant ");
        stepFirst.setFragment(new FirstFragment());
        stepFirst.setPositiveButtonEnable(false);

        steps.add(stepFirst);


        SteppersView steppersView = findViewById(R.id.steppersView);
        steppersView.setConfig(steppersViewConfig);
        steppersView.setItems(steps);
        steppersView.build();

 */
}

