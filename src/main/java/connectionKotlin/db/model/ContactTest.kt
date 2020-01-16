package connectionKotlin.db.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.AUTO
import javax.persistence.Id

@Entity
class ContactTest {
    @Id @GeneratedValue(strategy = AUTO)
    var objid: Long? = null

    @Column
    var firstName: String? = null

    @Column
    var lastName: String? = null
}