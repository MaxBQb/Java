package lab_16.Controller;

import lab_16.Model.Customer;
import lab_16.View.DeliveryAddress;

public class cDeliveryAddress {
    public cDeliveryAddress(DeliveryAddress view, Customer client){
        view.output_city.setText(client.getAddress().getCityName());
        view.output_street.setText(client.getAddress().getStreetName());
        view.output_house.setText(client.getAddress().getBuildingNumber() + "");
        view.output_building.setText(client.getAddress().getBuildingLetter() + "");
        view.output_flat.setText(client.getAddress().getApartmentNumber() + "");

        view.btn_submit.addActionListener(e -> { view.dispose(); });
    }
}
