package connectionKotlin.web.client

import connectionKotlin.db.model.ContactTest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@FeignClient(name = "client")
interface Client {
    @GetMapping(value = ["/db/getAllContacts"])
    @ResponseBody fun getAllContactsClient(): List<ContactTest>

    /**
     * value - address to call
     * Need to set @RequestParam annotation on parameters!
     */
    @GetMapping(value = ["/db/getContactTestById"])
    @ResponseBody fun getContactByIdClient(@RequestParam("id") id: Long): ContactTest

    @GetMapping(value = ["/db/getContactTestByFirstName"])
    @ResponseBody fun getContactByFirstNameClient(@RequestParam("firstName") firstName: String): ContactTest

    @GetMapping(value = ["db/createContactTest"])
    @ResponseBody fun createNewContactClient(@RequestParam("firstName") firstName: String, @RequestParam("lastName") lastName: String): ContactTest

    @GetMapping(value = ["db/deleteContactTestById"])
    @ResponseBody fun deleteByIdClient(@RequestParam("id") id: Long)

    @GetMapping(value = ["db/deleteAllContactTest"])
    @ResponseBody fun deleteAllClient()
}