package com.propecta.assignment.DTO;


import com.propecta.assignment.Entity.Entry;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CustomDataDTO {
    private int count;
    private List<Entry> entries;
}

