package chopenteries.api.entities.templates;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.security.Timestamp;

@MappedSuperclass
@Getter
public class DefaultEntity {

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT UPDATE_TIMESTAMP")
    private Timestamp updateAt;

    @Column(nullable = false, updatable = false)
    @Setter
    private String createdBy;

    @Column(nullable = false)
    @Setter
    private String updatedBy;

}
