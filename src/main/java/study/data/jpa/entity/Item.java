package study.data.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseTimeEntity implements Persistable<Long> {

    public Item(Long id) {
        this.id = id;
    }

    @Id
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate;

    @Override
    public boolean isNew() {
        return createdDate == null;
    }
}
