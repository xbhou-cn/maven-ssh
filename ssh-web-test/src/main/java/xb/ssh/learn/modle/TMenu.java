package xb.ssh.learn.modle;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TMenu")
public class TMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private TMenu pid;

    private String text;

    private String url;

    private String iconCls;

    private Set<TMenu> children;

    @Id
    @Column(name = "id", length = 40)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "pid")
    public TMenu getPid() {
        return pid;
    }

    public void setPid(TMenu pid) {
        this.pid = pid;
    }

    @Column(name = "url", length = 200)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "iconCls", length = 100)
    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    @Column(name = "text", length = 100)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<TMenu> getChildren() {
        return children;
    }

    public void setChildren(Set<TMenu> children) {
        this.children = children;
    }

}
