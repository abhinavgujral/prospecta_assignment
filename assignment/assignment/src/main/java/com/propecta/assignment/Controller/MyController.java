package com.propecta.assignment.Controller;
/*     Tasks :

        Create an API that lists the title, description based on the category passed as an input parameter.
        Create an API that would save a new entry with all the relevant properties which retrieves values from the endpoint GET /entries.
        Question: what are the key things you would consider when creating/consuming an API to
        ensure that it is secure and reliable?

        1. API Structure -->API should follow a correct namimg conventions
        2. Version  --> API should also follow the versioning of the system
        3. Security  --> API should be able to Authenticate and Authorize correctly
        4. Validation --> API should validate the data that is given by the user
        5. Rate limit --> API should limit the rate for an particular API's
        6. Error Handling --> Customize Error Handling Should be done in human readdable form.





*/

import com.propecta.assignment.DTO.CustomResponseDto;
import com.propecta.assignment.Entity.Entry;
import com.propecta.assignment.Exception.EntryException;
import com.propecta.assignment.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    MyService myService;

    /*
    URI--> /category
    What API does--> Get the list of entries based on category
    PathVariable--> category (type String)
    Response-->  List of entry title & description
     */
    @GetMapping("/{category}")
    public ResponseEntity<List<CustomResponseDto>> getByCategory(@PathVariable String category) throws EntryException {
        return new ResponseEntity<List<CustomResponseDto>>(myService.getByCategory(category), HttpStatus.OK);
    }

    /*
URI--> /entries
What API does--> Get the list of entries  from give URI and persist them in DB
Response--> String confirming values has been added
 */
    @PostMapping("/entries")
    public ResponseEntity<String> insertEntryHandler() throws EntryException{

        return new ResponseEntity<String>(myService.saveEntry(),HttpStatus.CREATED);
    }


}