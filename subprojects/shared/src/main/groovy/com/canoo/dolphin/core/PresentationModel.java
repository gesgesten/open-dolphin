package com.canoo.dolphin.core;

import java.util.List;

public interface PresentationModel extends Observable {
    String DIRTY_PROPERTY = "dirty";

    String getId();

    List<Attribute> getAttributes();

    Attribute findAttributeByPropertyName(String propertyName);

    Attribute findAttributeByDataId(String dataId);

    Attribute findAttributeById(long id);

    void syncWith(PresentationModel other);

    String getPresentationModelType();

    void addAttribute(Attribute attribute);
}