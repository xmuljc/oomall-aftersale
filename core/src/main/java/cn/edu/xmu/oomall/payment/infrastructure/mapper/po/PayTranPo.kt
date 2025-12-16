package cn.edu.xmu.oomall.payment.infrastructure.mapper.po

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(name = "payment_pay_trans", schema = "payment")
open class PayTranPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    open var id: Long? = null

    @Size(max = 128)
    @Column(name = "out_no", length = 128)
    open var outNo: String? = null

    @Size(max = 128)
    @Column(name = "trans_no", length = 128)
    open var transNo: String? = null

    @ColumnDefault("'0'")
    @Column(name = "amount", columnDefinition = "int UNSIGNED not null")
    open var amount: Long? = null

    @NotNull
    @ColumnDefault("0")
    @Column(name = "status", nullable = false)
    open var status: Byte? = null

    @Column(name = "success_time")
    open var successTime: Instant? = null

    @Size(max = 128)
    @Column(name = "sp_openid", length = 128)
    open var spOpenid: String? = null

    @Column(name = "time_expire")
    open var timeExpire: Instant? = null

    @Column(name = "time_begin")
    open var timeBegin: Instant? = null

    @Column(name = "account_id", columnDefinition = "int UNSIGNED not null")
    open var accountId: Long? = null

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

    @Size(max = 128)
    @Column(name = "prepay_id", length = 128)
    open var prepayId: String? = null

    @ColumnDefault("'0'")
    @Column(name = "div_amount", columnDefinition = "int UNSIGNED not null")
    open var divAmount: Long? = null

    @NotNull
    @ColumnDefault("0")
    @Column(name = "in_refund", nullable = false)
    open var inRefund: Byte? = null

    @Column(name = "shop_id", columnDefinition = "int UNSIGNED not null")
    open var shopId: Long? = null

    @Size(max = 128)
    @Column(name = "description", length = 128)
    open var description: String? = null
}