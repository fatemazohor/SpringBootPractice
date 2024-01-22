package com.example.SpringBootP3.controller;

import com.example.SpringBootP3.model.Vendors;
import com.example.SpringBootP3.model.buyer.Buyers;
import com.example.SpringBootP3.model.inventory.Purchase;
import com.example.SpringBootP3.model.inventory.PurchaseStatus;
import com.example.SpringBootP3.model.inventory.StockAdjustment;
import com.example.SpringBootP3.model.inventory.WareHouse;
import com.example.SpringBootP3.model.sale.RawMaterial;
import com.example.SpringBootP3.repository.inventory.IPurchase;
import com.example.SpringBootP3.repository.inventory.IPurchaseStatus;
import com.example.SpringBootP3.repository.inventory.IStockAdjustment;
import com.example.SpringBootP3.repository.inventory.IWareHouse;
import com.example.SpringBootP3.repository.other.IVendorRepo;
import com.example.SpringBootP3.repository.sale.IRawMaterialRepo;
import com.example.SpringBootP3.service.Stock.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InventoryController {
    @Autowired
    private IWareHouse wareHouseRepo;
    @Autowired
    private IPurchaseStatus purchaseStatusRepo;
    @Autowired
    private IPurchase iPurchaseRepo;
    @Autowired
    private IVendorRepo vendorRepo;
    @Autowired
    private IRawMaterialRepo iRawMaterialRepo;
    @Autowired
    private StockUpdateService stockUpdateService;
    @Autowired
    private IStockAdjustment stockAdjustmentRepo;

    //WareHouse start
    @GetMapping("/warehouse/list")
    public String warehouseList(Model m){
        List<WareHouse> warehouseList=wareHouseRepo.findAll();
        m.addAttribute("title","Warehouse List");
        m.addAttribute("warehouseList", warehouseList);
        return "inventory/warehouseList";
    }
    @GetMapping("/warehouse/addform")
    public String warehouseform(Model m){


        m.addAttribute("warehouse",new WareHouse());
        m.addAttribute("title","Create new Warehouse");
        return "inventory/warehouseForm";
    }

    @PostMapping("/warehouse/save")
    public String warehouseSave(@ModelAttribute WareHouse wareHouse){
        wareHouseRepo.save(wareHouse);
        return "redirect:/warehouse/list";
    }
    @GetMapping("/warehouse/delete/{id}")
    public String warehouseDelete(@PathVariable int id){
        wareHouseRepo.deleteById(id);
        return "redirect:/warehouse/list";
    }

    @GetMapping("/warehouse_edit/{id}")
    public String warehouseEdit(@PathVariable int id,Model m){
        WareHouse warehousename=wareHouseRepo.findById(id).get();
        m.addAttribute("title","Update Warehouse");
        m.addAttribute("warehouse",warehousename);
        return "inventory/warehouseForm";

    }
    //WareHouse end

    //Purchase Status

    @GetMapping("/purchase_status/list")
    public String purchaseStatusList(Model m){
        List<PurchaseStatus> purchaseStatusList=purchaseStatusRepo.findAll();
        m.addAttribute("title","Purchase Status List");
        m.addAttribute("purchaseStatusList", purchaseStatusList);
        return "inventory/purchaseStatusList";
    }
    @GetMapping("/purchase_status/addform")
    public String purchaseStatusform(Model m){

        m.addAttribute("purchaseStatus",new PurchaseStatus());
        m.addAttribute("title","Create new Purchase Status");
        return "inventory/purchaseStatusForm";
    }

    @PostMapping("/purchase_status/save")
    public String purchaseStatusSave(@ModelAttribute PurchaseStatus purchaseStatus){
        purchaseStatusRepo.save(purchaseStatus);
        return "redirect:/purchase_status/list";
    }
    @GetMapping("/purchase_status/delete/{id}")
    public String purchaseStatusDelete(@PathVariable int id){
        purchaseStatusRepo.deleteById(id);
        return "redirect:/purchase_status/list";
    }

    @GetMapping("/purchase_status_edit/{id}")
    public String purchaseStatusEdit(@PathVariable int id,Model m){
        PurchaseStatus purchaseStatusname=purchaseStatusRepo.findById(id).get();
        m.addAttribute("title","Update Purchase Status");
        m.addAttribute("purchaseStatus",purchaseStatusname);
        return "inventory/purchaseStatusForm";

    }



    //Purchase Status end

    //Purchase Table
    @GetMapping("/purchase/list")
    public String purchaseList(Model m){



        List<Purchase> purchaseList=iPurchaseRepo.findAll();
        m.addAttribute("title","Purchase List");
        m.addAttribute("purchaseList", purchaseList);
        return "inventory/purchaseList";
    }
    @GetMapping("/purchase/addform")
    public String purchaseform(Model m){
        //vendor dropdown
        List<Vendors> vendorList=vendorRepo.findAll();
        m.addAttribute("vendorList", vendorList);
        //purchase Status dropdown
        List<PurchaseStatus> purchaseStatusList=purchaseStatusRepo.findAll();
        m.addAttribute("purchaseStatusList", purchaseStatusList);
        //warehouse dropdown
        List<WareHouse> warehouseList=wareHouseRepo.findAll();
        m.addAttribute("warehouseList", warehouseList);
        //raw Material dropdown
        List<RawMaterial> rawMaterialList=iRawMaterialRepo.findAll();
        m.addAttribute("rawMaterialList", rawMaterialList);



        m.addAttribute("purchase",new Purchase());
        m.addAttribute("title","Create new Purchase");
        return "inventory/purchaseForm";
    }

    @PostMapping("/purchase/save")
    public String purchaseSave(@ModelAttribute Purchase purchase){
        double myquantity = purchase.getQuantity();
        int myid=purchase.getRawMaterialId().getId();
        stockUpdateService.addStockData(myid,myquantity);
        iPurchaseRepo.save(purchase);
        return "redirect:/purchase/list";
    }
    @GetMapping("/purchase/delete/{id}")
    public String purchaseDelete(@PathVariable int id){
        iPurchaseRepo.deleteById(id);
        return "redirect:/purchase/list";
    }

    @GetMapping("/purchase_edit/{id}")
    public String purchaseEdit(@PathVariable int id,Model m){
        //vendor dropdown
        List<Vendors> vendorList=vendorRepo.findAll();
        m.addAttribute("vendorList", vendorList);
        //purchase Status dropdown
        List<PurchaseStatus> purchaseStatusList=purchaseStatusRepo.findAll();
        m.addAttribute("purchaseStatusList", purchaseStatusList);
        //warehouse dropdown
        List<WareHouse> warehouseList=wareHouseRepo.findAll();
        m.addAttribute("warehouseList", warehouseList);
        //raw Material dropdown
        List<RawMaterial> rawMaterialList=iRawMaterialRepo.findAll();
        m.addAttribute("rawMaterialList", rawMaterialList);

        Purchase purchaseName=iPurchaseRepo.findById(id).get();
        m.addAttribute("title","Update Purchase");
        m.addAttribute("purchase",purchaseName);
        return "inventory/purchaseForm";

    }
    //Purchase Table end

    //Stock Adjustment

    @GetMapping("/stock_adjustment_status/list")
    public String stockAdjustmentStatusList(Model m){
        List<StockAdjustment> stockAdjustmentStatusList=stockAdjustmentRepo.findAll();
        m.addAttribute("title","Stock Adjustment Status List");
        m.addAttribute("stockAdjustmentStatusList", stockAdjustmentStatusList);
        return "inventory/stockAdjustmentList";
    }
    @GetMapping("/stock_adjustment_status/addform")
    public String stockAdjustmentStatusform(Model m){

        m.addAttribute("stockAdjustmentStatus",new StockAdjustment());
        m.addAttribute("title","Create new Stock Adjustment Status");
        return "inventory/stockAdjustmentForm";
    }

    @PostMapping("/stock_adjustment_status/save")
    public String stockAdjustmentStatusSave(@ModelAttribute StockAdjustment stockAdjustment){
        stockAdjustmentRepo.save(stockAdjustment);
        return "redirect:/stock_adjustment_status/list";
    }
    @GetMapping("/stock_adjustment_status/delete/{id}")
    public String stockAdjustmentStatusDelete(@PathVariable int id){
        stockAdjustmentRepo.deleteById(id);
        return "redirect:/stock_adjustment_status/list";
    }

    @GetMapping("/stock_adjustment_status_edit/{id}")
    public String stockAdjustmentStatusEdit(@PathVariable int id,Model m){
        StockAdjustment stockAdjustmentStatusname=stockAdjustmentRepo.findById(id).get();
        m.addAttribute("title","Update Stock Adjustment Status");
        m.addAttribute("stockAdjustmentStatus",stockAdjustmentStatusname);
        return "inventory/stockAdjustmentForm";

    }


    //Stock Adjustment end
}
