package com.propecta.assignment.DTO;

import com.propecta.assignment.Entity.Entry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponseDto {
    private  String title ;
    private String description;

}