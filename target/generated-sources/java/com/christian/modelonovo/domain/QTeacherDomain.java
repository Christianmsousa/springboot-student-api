package com.christian.modelonovo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeacherDomain is a Querydsl query type for TeacherDomain
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTeacherDomain extends EntityPathBase<TeacherDomain> {

    private static final long serialVersionUID = 428020584L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTeacherDomain teacherDomain = new QTeacherDomain("teacherDomain");

    public final NumberPath<Long> age = createNumber("age", Long.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QSubjectDomain subject;

    public QTeacherDomain(String variable) {
        this(TeacherDomain.class, forVariable(variable), INITS);
    }

    public QTeacherDomain(Path<? extends TeacherDomain> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTeacherDomain(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTeacherDomain(PathMetadata metadata, PathInits inits) {
        this(TeacherDomain.class, metadata, inits);
    }

    public QTeacherDomain(Class<? extends TeacherDomain> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.subject = inits.isInitialized("subject") ? new QSubjectDomain(forProperty("subject"), inits.get("subject")) : null;
    }

}

