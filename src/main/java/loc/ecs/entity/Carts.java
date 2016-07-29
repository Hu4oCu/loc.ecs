package loc.ecs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ecs_cart")
public class Carts implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq_gen")
    @SequenceGenerator(name = "cart_seq_gen", sequenceName = "cart_id_seq", allocationSize = 1)
    @Column(name = "cart_id", nullable = false, unique = true, insertable = false, updatable = false)
    private int cid;
    @Column(name = "user_id")
    private int uid;
    @Column(name = "product_id")
    private int pid;
    @Column(name = "count")
    private int count;

    protected Carts() {}

    public Carts(int uid, int pid, int count) {
        this.uid = uid;
        this.pid = pid;
        this.count = count;
    }

    public Carts(int cid, int uid, int pid, int count) {
        this.cid = cid;
        this.uid = uid;
        this.pid = pid;
        this.count = count;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}