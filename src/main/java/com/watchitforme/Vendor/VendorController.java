package com.watchitforme.Vendor;

import com.watchitforme.ChuckNorris.ChuckNorris;
import com.watchitforme.Item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class VendorController {
    private ChuckNorris chuckNorris;

    @RequestMapping("/vendor")
    public List<String> listVendors() {
        ChuckNorris chuckNorris = new ChuckNorris();
        chuckNorris.setType("roundhouse");
        chuckNorris = null;

        return new ArrayList<>();
    }
//
//        List<String> vendors = new ArrayList<>();
//        vendors.add("Amazon");
//        vendors.add("Ao");
//        vendors.add("Argos");
//        vendors.add("B&Q");
//        vendors.add("BT Shop");
//        vendors.add("Currys");
//        vendors.add("Debenhams");
//        vendors.add("Game");
//        vendors.add("Halfords");
//        vendors.add("Homebase");
//        vendors.add("House of Fraser");
//        vendors.add("John Lewis");
//        vendors.add("Mamas & Pappas");
//        vendors.add("Marks & Spencer");
//        vendors.add("PC World");
//        vendors.add("Smyths Toys");
//        vendors.add("Tesco");
//        vendors.add("Toys R Us");
//        return vendors;
//    }
}
