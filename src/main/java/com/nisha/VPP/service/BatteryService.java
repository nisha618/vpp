package com.nisha.VPP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nisha.VPP.entity.BatteriesModel;
import com.nisha.VPP.repository.BatteryRepository;

@Service
public class BatteryService {

    @Autowired
    private BatteryRepository batteryRepo;


    public BatteriesModel save(BatteriesModel batteryModel){
        return batteryRepo.save(batteryModel);
        
    }

    public BatteriesModel update(BatteriesModel batteryModel,int id){
        BatteriesModel obj = batteryRepo.findById(id).get();
        if(batteryModel.getName().compareTo("") == 0){
            obj.setName(batteryModel.getName());
        }
        if(batteryModel.getPostCode().compareTo("") == 0){
            obj.setPostCode(batteryModel.getPostCode());
        }
        if(batteryModel.getCapacity().compareTo("") == 0){
            obj.setCapacity(batteryModel.getCapacity());
        }
        return batteryRepo.save(obj);
        
    }

    public List<BatteriesModel> getBatteryList(){
        List<BatteriesModel> list = batteryRepo.batteryList();
        if(list == null){
            list= new ArrayList<BatteriesModel>();
        }
        return list;
        
    }

    public void deleteById(int id){
         batteryRepo.deleteById(id);
        
    }
    
}