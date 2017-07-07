package ${package}.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by akalsan on 10/4/16.
 */


@Entity
@Table(name = "roles")
public class RoleEntity implements org.eurekaclinical.standardapis.entity.RoleEntity {

    @Id
    @SequenceGenerator(name = "ROLE_SEQ_GENERATOR", sequenceName = "ROLE_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ROLE_SEQ_GENERATOR")
    private Long id;
    /**
     * The role's name.
     */
    @Column(unique = true, nullable = false)
    private String name;
    /**
     * Is this role a default role? Default roles are assigned to all new users.
     */
    private boolean defaultRole;

    /**
     * Create an empty role.
     */
    public RoleEntity() {
    }

    /**
     * Get the role's identification number.
     *
     * @return A {@link Long} representing the role's id.
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Set the role's identification number.
     *
     * @param inId The number representing the role's id.
     */
    @Override
    public void setId(Long inId) {
        this.id = inId;
    }

    /**
     * Get the role's name.
     *
     * @return A String containing the role's name.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Set the role's name.
     *
     * @param inName A string containing the role's name.
     */
    @Override
    public void setName(String inName) {
        this.name = inName;
    }

    /**
     * Is this role a default role?
     *
     * @return True if the role is a default role, false otherwise.
     */
    @Override
    public boolean isDefaultRole() {
        return this.defaultRole;
    }

    /**
     * Set the role's default flag.
     *
     * @param inDefaultRole True or False, True indicating a default role, False
     * indicating a non-default role.
     */
    @Override
    public void setDefaultRole(boolean inDefaultRole) {
        this.defaultRole = inDefaultRole;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoleEntity other = (RoleEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RoleEntity{" + "id=" + id + ", name=" + name + ", defaultRole=" + defaultRole + '}';
    }

}
