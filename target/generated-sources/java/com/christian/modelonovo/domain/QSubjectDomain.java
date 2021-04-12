package com.christian.modelonovo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubjectDomain is a Querydsl query type for SubjectDomain
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubjectDomain extends EntityPathBase<SubjectDomain> {

    private static final long serialVersionUID = -969016014L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubjectDomain subjectDomain = new QSubjectDomain("subjectDomain");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QTeacherDomain teacher;

    public QSubjectDomain(String variable) {
        this(SubjectDomain.class, forVariable(variable), INITS);
    }

    public QSubjectDomain(Path<? extends SubjectDomain> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubjectDomain(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubjectDomain(PathMetadata metadata, PathInits inits) {
        this(SubjectDomain.class, metadata, inits);
    }

    public QSubjectDomain(Class<? extends SubjectDomain> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.teacher = inits.isInitialized("teacher") ? new QTeacherDomain(forProperty("teacher"), inits.get("teacher")) : null;
    }

}

