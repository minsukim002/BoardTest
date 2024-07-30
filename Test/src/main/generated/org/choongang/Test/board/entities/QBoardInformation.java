package org.choongang.Test.board.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardInformation is a Querydsl query type for BoardInformation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardInformation extends EntityPathBase<BoardInformation> {

    private static final long serialVersionUID = 1947948587L;

    public static final QBoardInformation boardInformation = new QBoardInformation("boardInformation");

    public final org.choongang.Test.global.entities.QBaseEntity _super = new org.choongang.Test.global.entities.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath title = createString("title");

    public final StringPath writer = createString("writer");

    public QBoardInformation(String variable) {
        super(BoardInformation.class, forVariable(variable));
    }

    public QBoardInformation(Path<? extends BoardInformation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardInformation(PathMetadata metadata) {
        super(BoardInformation.class, metadata);
    }

}

