package getyourolyweight.presentation;

import getyourolyweight.businesslogic.WeightLiftManager;

/**
 * Created by r.ceuleers on 25-9-2016.
 */


public class Main {
    private Main() {
    }
    public static void main(String[] args) {
        WeightLiftUI ui = new WeightLiftUI(new WeightLiftManager() );
        ui.setVisible( true);
    }
}







