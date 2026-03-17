package com.mygroup.Contexts;

import com.mygroup.Services.AddSpecialityService;
import com.mygroup.Services.SpecialityService;

public class MainContext {
    public SpecialityService specialityService;
    public AddSpecialityService addSpecialityService;

    public MainContext(
            SpecialityService specialityService,
            AddSpecialityService addSpecialityService
    ) {
        this.addSpecialityService = addSpecialityService;
        this.specialityService = specialityService;
    }

}
