package cn.edu.xmu.oomall.payment.infrastructure.mapper.po

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(name = "payment_account", schema = "payment")
open class AccountPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    open var id: Long? = null

    @Column(name = "shop_id", columnDefinition = "int UNSIGNED not null")
    open var shopId: Long? = null

    @Size(max = 128)
    @NotNull
    @Column(name = "sub_mchid", nullable = false, length = 128)
    open var subMchid: String? = null

    @Column(name = "channel_id", columnDefinition = "int UNSIGNED not null")
    open var channelId: Long? = null

    @Size(max = 128)
    @Column(name = "creator", length = 128)
    open var creator: String? = null

    @Size(max = 128)
    @Column(name = "modifier", length = 128)
    open var modifier: String? = null

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "gmt_create", nullable = false)
    open var gmtCreate: Instant? = null

    @Column(name = "gmt_modified")
    open var gmtModified: Instant? = null

    @NotNull
    @ColumnDefault("1")
    @Column(name = "status", nullable = false)
    open var status: Byte? = null
}