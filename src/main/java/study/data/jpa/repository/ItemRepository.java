package study.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.data.jpa.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
