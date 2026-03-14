package com.mygroup.Contexts;

import com.mygroup.Services.AddSpecialityService;
import com.mygroup.Services.SpecialityService;

public class SpecialityContext {
    public SpecialityService specialityService;
    public AddSpecialityService addSpecialityService;

    public SpecialityContext(
            SpecialityService specialityService,
            AddSpecialityService addSpecialityService
    ) {
        this.addSpecialityService = addSpecialityService;
        this.specialityService = specialityService;
    }

}
