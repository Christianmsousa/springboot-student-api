package com.christian.modelonovo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClassControlDomain is a Querydsl query type for ClassControlDomain
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClassControlDomain extends EntityPathBase<ClassControlDomain> {

    private static final long serialVersionUID = 1452401415L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClassControlDomain classControlDomain = new QClassControlDomain("classControlDomain");

    public final QCourseDomain course;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QSubjectDomain subject;

    public QClassControlDomain(String variable) {
        this(ClassControlDomain.class, forVariable(variable), INITS);
    }

    public QClassControlDomain(Path<? extends ClassControlDomain> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClassControlDomain(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClassControlDomain(PathMetadata metadata, PathInits inits) {
        this(ClassControlDomain.class, metadata, inits);
    }

    public QClassControlDomain(Class<? extends ClassControlDomain> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new QCourseDomain(forProperty("course")) : null;
        this.subject = inits.isInitialized("subject") ? new QSubjectDomain(forProperty("subject"), inits.get("subject")) : null;
    }

}

