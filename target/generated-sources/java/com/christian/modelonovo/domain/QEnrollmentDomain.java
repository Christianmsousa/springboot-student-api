package com.christian.modelonovo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEnrollmentDomain is a Querydsl query type for EnrollmentDomain
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEnrollmentDomain extends EntityPathBase<EnrollmentDomain> {

    private static final long serialVersionUID = 1562824070L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEnrollmentDomain enrollmentDomain = new QEnrollmentDomain("enrollmentDomain");

    public final QCourseDomain course;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QStudentDomain student;

    public QEnrollmentDomain(String variable) {
        this(EnrollmentDomain.class, forVariable(variable), INITS);
    }

    public QEnrollmentDomain(Path<? extends EnrollmentDomain> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEnrollmentDomain(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEnrollmentDomain(PathMetadata metadata, PathInits inits) {
        this(EnrollmentDomain.class, metadata, inits);
    }

    public QEnrollmentDomain(Class<? extends EnrollmentDomain> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.course = inits.isInitialized("course") ? new QCourseDomain(forProperty("course")) : null;
        this.student = inits.isInitialized("student") ? new QStudentDomain(forProperty("student")) : null;
    }

}

