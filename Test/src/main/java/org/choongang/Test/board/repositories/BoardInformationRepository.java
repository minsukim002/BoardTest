package org.choongang.Test.board.repositories;

import org.choongang.Test.board.entities.BoardInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardInformationRepository extends JpaRepository<BoardInformation, Long> {
}
