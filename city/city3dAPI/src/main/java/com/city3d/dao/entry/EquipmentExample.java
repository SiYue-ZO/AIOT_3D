package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class EquipmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(String value) {
            addCriterion("equipment_id =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(String value) {
            addCriterion("equipment_id <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(String value) {
            addCriterion("equipment_id >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_id >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(String value) {
            addCriterion("equipment_id <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(String value) {
            addCriterion("equipment_id <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLike(String value) {
            addCriterion("equipment_id like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotLike(String value) {
            addCriterion("equipment_id not like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<String> values) {
            addCriterion("equipment_id in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<String> values) {
            addCriterion("equipment_id not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(String value1, String value2) {
            addCriterion("equipment_id between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(String value1, String value2) {
            addCriterion("equipment_id not between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIsNull() {
            addCriterion("equipment_type is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIsNotNull() {
            addCriterion("equipment_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeEqualTo(String value) {
            addCriterion("equipment_type =", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotEqualTo(String value) {
            addCriterion("equipment_type <>", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeGreaterThan(String value) {
            addCriterion("equipment_type >", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_type >=", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLessThan(String value) {
            addCriterion("equipment_type <", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLessThanOrEqualTo(String value) {
            addCriterion("equipment_type <=", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLike(String value) {
            addCriterion("equipment_type like", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotLike(String value) {
            addCriterion("equipment_type not like", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIn(List<String> values) {
            addCriterion("equipment_type in", values, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotIn(List<String> values) {
            addCriterion("equipment_type not in", values, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeBetween(String value1, String value2) {
            addCriterion("equipment_type between", value1, value2, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotBetween(String value1, String value2) {
            addCriterion("equipment_type not between", value1, value2, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNull() {
            addCriterion("equipment_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNotNull() {
            addCriterion("equipment_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameEqualTo(String value) {
            addCriterion("equipment_name =", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotEqualTo(String value) {
            addCriterion("equipment_name <>", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThan(String value) {
            addCriterion("equipment_name >", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_name >=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThan(String value) {
            addCriterion("equipment_name <", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThanOrEqualTo(String value) {
            addCriterion("equipment_name <=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLike(String value) {
            addCriterion("equipment_name like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotLike(String value) {
            addCriterion("equipment_name not like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIn(List<String> values) {
            addCriterion("equipment_name in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotIn(List<String> values) {
            addCriterion("equipment_name not in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameBetween(String value1, String value2) {
            addCriterion("equipment_name between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotBetween(String value1, String value2) {
            addCriterion("equipment_name not between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeIsNull() {
            addCriterion("equipment_grade is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeIsNotNull() {
            addCriterion("equipment_grade is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeEqualTo(String value) {
            addCriterion("equipment_grade =", value, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeNotEqualTo(String value) {
            addCriterion("equipment_grade <>", value, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeGreaterThan(String value) {
            addCriterion("equipment_grade >", value, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_grade >=", value, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeLessThan(String value) {
            addCriterion("equipment_grade <", value, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeLessThanOrEqualTo(String value) {
            addCriterion("equipment_grade <=", value, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeLike(String value) {
            addCriterion("equipment_grade like", value, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeNotLike(String value) {
            addCriterion("equipment_grade not like", value, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeIn(List<String> values) {
            addCriterion("equipment_grade in", values, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeNotIn(List<String> values) {
            addCriterion("equipment_grade not in", values, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeBetween(String value1, String value2) {
            addCriterion("equipment_grade between", value1, value2, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentGradeNotBetween(String value1, String value2) {
            addCriterion("equipment_grade not between", value1, value2, "equipmentGrade");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureIsNull() {
            addCriterion("equipment_picture is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureIsNotNull() {
            addCriterion("equipment_picture is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureEqualTo(String value) {
            addCriterion("equipment_picture =", value, "equipmentPicture");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureNotEqualTo(String value) {
            addCriterion("equipment_picture <>", value, "equipmentPicture");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureGreaterThan(String value) {
            addCriterion("equipment_picture >", value, "equipmentPicture");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_picture >=", value, "equipmentPicture");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureLessThan(String value) {
            addCriterion("equipment_picture <", value, "equipmentPicture");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureLessThanOrEqualTo(String value) {
            addCriterion("equipment_picture <=", value, "equipmentPicture");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureLike(String value) {
            addCriterion("equipment_picture like", value, "equipmentPicture");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureNotLike(String value) {
            addCriterion("equipment_picture not like", value, "equipmentPicture");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureIn(List<String> values) {
            addCriterion("equipment_picture in", values, "equipmentPicture");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureNotIn(List<String> values) {
            addCriterion("equipment_picture not in", values, "equipmentPicture");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureBetween(String value1, String value2) {
            addCriterion("equipment_picture between", value1, value2, "equipmentPicture");
            return (Criteria) this;
        }

        public Criteria andEquipmentPictureNotBetween(String value1, String value2) {
            addCriterion("equipment_picture not between", value1, value2, "equipmentPicture");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}