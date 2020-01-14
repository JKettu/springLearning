package dbconnection.client;

import dbconnection.model.ContactTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Interface is an example of interaction with feign.
 * Represents client, which calls DbController's methods.
 */
@FeignClient(value = "contact", url = "http://localhost:8080")
public interface ContactClient {

    @RequestMapping(method = GET, value = "/testDb/getAllContacts")
    @ResponseBody List<ContactTest> getAllContactsClient();

    /**
     * value - address to call
     * Need to set @RequestParam annotation on parameters!
     */
    @RequestMapping(method = GET, value = "/testDb/getContactById")
    @ResponseBody ContactTest getContactByIdClient(@RequestParam("id") Long id);

    @RequestMapping(method = GET, value = "/testDb/getContactByFirstName")
    @ResponseBody ContactTest getContactByFirstNameClient(@RequestParam("firstName") String firstName);

    @RequestMapping(method = GET, value = "testDb/createContact")
    @ResponseBody ContactTest createNewContactClient(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName);

    @RequestMapping(method = GET, value = "testDb/deleteById")
    @ResponseBody void deleteByIdClient(@RequestParam("id") Long id);

    @RequestMapping(method = GET, value = "testDb/deleteAll")
    @ResponseBody void deleteAllClient();
}
