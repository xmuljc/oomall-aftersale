package cn.edu.xmu.oomall.payment.infrastructure.mapper.po

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(name = "payment_channel", schema = "payment")
open class ChannelPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    open var id: Long? = null

    @Size(max = 128)
    @NotNull
    @Column(name = "sp_appid", nullable = false, length = 128)
    open var spAppid: String? = null

    @Size(max = 128)
    @NotNull
    @Column(name = "name", nullable = false, length = 128)
    open var name: String? = null

    @Size(max = 128)
    @NotNull
    @Column(name = "sp_mchid", nullable = false, length = 128)
    open var spMchid: String? = null

    @Column(name = "begin_time")
    open var beginTime: Instant? = null

    @Column(name = "end_time")
    open var endTime: Instant? = null

    @NotNull
    @ColumnDefault("1")
    @Column(name = "status", nullable = false)
    open var status: Byte? = null

    @Size(max = 256)
    @Column(name = "bean_name", length = 256)
    open var beanName: String? = null

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
}