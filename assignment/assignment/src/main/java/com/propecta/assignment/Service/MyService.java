package com.propecta.assignment.Service;

import com.propecta.assignment.DTO.CustomDataDTO;
import com.propecta.assignment.DTO.CustomResponseDto;
import com.propecta.assignment.Entity.Entry;
import com.propecta.assignment.Exception.EntryException;
import com.propecta.assignment.Repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {

    @Autowired
    EntryRepository entryRepository;


    public List<CustomResponseDto> getByCategory(String category) {
      CustomDataDTO customDataDTO=  new RestTemplate().getForObject("https://api.publicapis.org/entries", CustomDataDTO.class);

        List<CustomResponseDto> responseList = new ArrayList<>();

        for(Entry e: customDataDTO.getEntries()){
            if(e.getCategory().equals(category)){
                responseList.add(new CustomResponseDto(e.getApi(),e.getDescription()));
            }
        }
        if(responseList.size() == 0){
            throw new EntryException("Entry for category not found: " + category);
        }
        return responseList;

    }

    public String saveEntry() {

        CustomDataDTO customDataDTO=  new RestTemplate().getForObject("https://api.publicapis.org/entries", CustomDataDTO.class);
        List<Entry> entries= customDataDTO.getEntries();
        try {
            for (Entry i : entries)
                entryRepository.save(i);
        }catch(Exception e){
            throw new EntryException("Entries are not saved");
        }
        return "Entries saved successfully";
    }
}