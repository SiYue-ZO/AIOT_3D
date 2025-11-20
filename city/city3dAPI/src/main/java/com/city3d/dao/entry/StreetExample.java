package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class StreetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StreetExample() {
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

        public Criteria andStreetIdIsNull() {
            addCriterion("street_id is null");
            return (Criteria) this;
        }

        public Criteria andStreetIdIsNotNull() {
            addCriterion("street_id is not null");
            return (Criteria) this;
        }

        public Criteria andStreetIdEqualTo(String value) {
            addCriterion("street_id =", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotEqualTo(String value) {
            addCriterion("street_id <>", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdGreaterThan(String value) {
            addCriterion("street_id >", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdGreaterThanOrEqualTo(String value) {
            addCriterion("street_id >=", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdLessThan(String value) {
            addCriterion("street_id <", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdLessThanOrEqualTo(String value) {
            addCriterion("street_id <=", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdLike(String value) {
            addCriterion("street_id like", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotLike(String value) {
            addCriterion("street_id not like", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdIn(List<String> values) {
            addCriterion("street_id in", values, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotIn(List<String> values) {
            addCriterion("street_id not in", values, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdBetween(String value1, String value2) {
            addCriterion("street_id between", value1, value2, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotBetween(String value1, String value2) {
            addCriterion("street_id not between", value1, value2, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetNameIsNull() {
            addCriterion("street_name is null");
            return (Criteria) this;
        }

        public Criteria andStreetNameIsNotNull() {
            addCriterion("street_name is not null");
            return (Criteria) this;
        }

        public Criteria andStreetNameEqualTo(String value) {
            addCriterion("street_name =", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotEqualTo(String value) {
            addCriterion("street_name <>", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameGreaterThan(String value) {
            addCriterion("street_name >", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameGreaterThanOrEqualTo(String value) {
            addCriterion("street_name >=", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameLessThan(String value) {
            addCriterion("street_name <", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameLessThanOrEqualTo(String value) {
            addCriterion("street_name <=", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameLike(String value) {
            addCriterion("street_name like", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotLike(String value) {
            addCriterion("street_name not like", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameIn(List<String> values) {
            addCriterion("street_name in", values, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotIn(List<String> values) {
            addCriterion("street_name not in", values, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameBetween(String value1, String value2) {
            addCriterion("street_name between", value1, value2, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotBetween(String value1, String value2) {
            addCriterion("street_name not between", value1, value2, "streetName");
            return (Criteria) this;
        }

        public Criteria andPoiIsNull() {
            addCriterion("poi is null");
            return (Criteria) this;
        }

        public Criteria andPoiIsNotNull() {
            addCriterion("poi is not null");
            return (Criteria) this;
        }

        public Criteria andPoiEqualTo(String value) {
            addCriterion("poi =", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotEqualTo(String value) {
            addCriterion("poi <>", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiGreaterThan(String value) {
            addCriterion("poi >", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiGreaterThanOrEqualTo(String value) {
            addCriterion("poi >=", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiLessThan(String value) {
            addCriterion("poi <", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiLessThanOrEqualTo(String value) {
            addCriterion("poi <=", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiLike(String value) {
            addCriterion("poi like", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotLike(String value) {
            addCriterion("poi not like", value, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiIn(List<String> values) {
            addCriterion("poi in", values, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotIn(List<String> values) {
            addCriterion("poi not in", values, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiBetween(String value1, String value2) {
            addCriterion("poi between", value1, value2, "poi");
            return (Criteria) this;
        }

        public Criteria andPoiNotBetween(String value1, String value2) {
            addCriterion("poi not between", value1, value2, "poi");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andRowIdIsNull() {
            addCriterion("row_id is null");
            return (Criteria) this;
        }

        public Criteria andRowIdIsNotNull() {
            addCriterion("row_id is not null");
            return (Criteria) this;
        }

        public Criteria andRowIdEqualTo(String value) {
            addCriterion("row_id =", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdNotEqualTo(String value) {
            addCriterion("row_id <>", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdGreaterThan(String value) {
            addCriterion("row_id >", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdGreaterThanOrEqualTo(String value) {
            addCriterion("row_id >=", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdLessThan(String value) {
            addCriterion("row_id <", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdLessThanOrEqualTo(String value) {
            addCriterion("row_id <=", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdLike(String value) {
            addCriterion("row_id like", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdNotLike(String value) {
            addCriterion("row_id not like", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdIn(List<String> values) {
            addCriterion("row_id in", values, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdNotIn(List<String> values) {
            addCriterion("row_id not in", values, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdBetween(String value1, String value2) {
            addCriterion("row_id between", value1, value2, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdNotBetween(String value1, String value2) {
            addCriterion("row_id not between", value1, value2, "rowId");
            return (Criteria) this;
        }

        public Criteria andStreetCheckIsNull() {
            addCriterion("street_check is null");
            return (Criteria) this;
        }

        public Criteria andStreetCheckIsNotNull() {
            addCriterion("street_check is not null");
            return (Criteria) this;
        }

        public Criteria andStreetCheckEqualTo(String value) {
            addCriterion("street_check =", value, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andStreetCheckNotEqualTo(String value) {
            addCriterion("street_check <>", value, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andStreetCheckGreaterThan(String value) {
            addCriterion("street_check >", value, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andStreetCheckGreaterThanOrEqualTo(String value) {
            addCriterion("street_check >=", value, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andStreetCheckLessThan(String value) {
            addCriterion("street_check <", value, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andStreetCheckLessThanOrEqualTo(String value) {
            addCriterion("street_check <=", value, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andStreetCheckLike(String value) {
            addCriterion("street_check like", value, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andStreetCheckNotLike(String value) {
            addCriterion("street_check not like", value, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andStreetCheckIn(List<String> values) {
            addCriterion("street_check in", values, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andStreetCheckNotIn(List<String> values) {
            addCriterion("street_check not in", values, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andStreetCheckBetween(String value1, String value2) {
            addCriterion("street_check between", value1, value2, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andStreetCheckNotBetween(String value1, String value2) {
            addCriterion("street_check not between", value1, value2, "streetCheck");
            return (Criteria) this;
        }

        public Criteria andWordSizeIsNull() {
            addCriterion("word_size is null");
            return (Criteria) this;
        }

        public Criteria andWordSizeIsNotNull() {
            addCriterion("word_size is not null");
            return (Criteria) this;
        }

        public Criteria andWordSizeEqualTo(String value) {
            addCriterion("word_size =", value, "wordSize");
            return (Criteria) this;
        }

        public Criteria andWordSizeNotEqualTo(String value) {
            addCriterion("word_size <>", value, "wordSize");
            return (Criteria) this;
        }

        public Criteria andWordSizeGreaterThan(String value) {
            addCriterion("word_size >", value, "wordSize");
            return (Criteria) this;
        }

        public Criteria andWordSizeGreaterThanOrEqualTo(String value) {
            addCriterion("word_size >=", value, "wordSize");
            return (Criteria) this;
        }

        public Criteria andWordSizeLessThan(String value) {
            addCriterion("word_size <", value, "wordSize");
            return (Criteria) this;
        }

        public Criteria andWordSizeLessThanOrEqualTo(String value) {
            addCriterion("word_size <=", value, "wordSize");
            return (Criteria) this;
        }

        public Criteria andWordSizeLike(String value) {
            addCriterion("word_size like", value, "wordSize");
            return (Criteria) this;
        }

        public Criteria andWordSizeNotLike(String value) {
            addCriterion("word_size not like", value, "wordSize");
            return (Criteria) this;
        }

        public Criteria andWordSizeIn(List<String> values) {
            addCriterion("word_size in", values, "wordSize");
            return (Criteria) this;
        }

        public Criteria andWordSizeNotIn(List<String> values) {
            addCriterion("word_size not in", values, "wordSize");
            return (Criteria) this;
        }

        public Criteria andWordSizeBetween(String value1, String value2) {
            addCriterion("word_size between", value1, value2, "wordSize");
            return (Criteria) this;
        }

        public Criteria andWordSizeNotBetween(String value1, String value2) {
            addCriterion("word_size not between", value1, value2, "wordSize");
            return (Criteria) this;
        }

        public Criteria andRotationAngleIsNull() {
            addCriterion("rotation_angle is null");
            return (Criteria) this;
        }

        public Criteria andRotationAngleIsNotNull() {
            addCriterion("rotation_angle is not null");
            return (Criteria) this;
        }

        public Criteria andRotationAngleEqualTo(String value) {
            addCriterion("rotation_angle =", value, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andRotationAngleNotEqualTo(String value) {
            addCriterion("rotation_angle <>", value, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andRotationAngleGreaterThan(String value) {
            addCriterion("rotation_angle >", value, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andRotationAngleGreaterThanOrEqualTo(String value) {
            addCriterion("rotation_angle >=", value, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andRotationAngleLessThan(String value) {
            addCriterion("rotation_angle <", value, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andRotationAngleLessThanOrEqualTo(String value) {
            addCriterion("rotation_angle <=", value, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andRotationAngleLike(String value) {
            addCriterion("rotation_angle like", value, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andRotationAngleNotLike(String value) {
            addCriterion("rotation_angle not like", value, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andRotationAngleIn(List<String> values) {
            addCriterion("rotation_angle in", values, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andRotationAngleNotIn(List<String> values) {
            addCriterion("rotation_angle not in", values, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andRotationAngleBetween(String value1, String value2) {
            addCriterion("rotation_angle between", value1, value2, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andRotationAngleNotBetween(String value1, String value2) {
            addCriterion("rotation_angle not between", value1, value2, "rotationAngle");
            return (Criteria) this;
        }

        public Criteria andShowHeightIsNull() {
            addCriterion("show_height is null");
            return (Criteria) this;
        }

        public Criteria andShowHeightIsNotNull() {
            addCriterion("show_height is not null");
            return (Criteria) this;
        }

        public Criteria andShowHeightEqualTo(String value) {
            addCriterion("show_height =", value, "showHeight");
            return (Criteria) this;
        }

        public Criteria andShowHeightNotEqualTo(String value) {
            addCriterion("show_height <>", value, "showHeight");
            return (Criteria) this;
        }

        public Criteria andShowHeightGreaterThan(String value) {
            addCriterion("show_height >", value, "showHeight");
            return (Criteria) this;
        }

        public Criteria andShowHeightGreaterThanOrEqualTo(String value) {
            addCriterion("show_height >=", value, "showHeight");
            return (Criteria) this;
        }

        public Criteria andShowHeightLessThan(String value) {
            addCriterion("show_height <", value, "showHeight");
            return (Criteria) this;
        }

        public Criteria andShowHeightLessThanOrEqualTo(String value) {
            addCriterion("show_height <=", value, "showHeight");
            return (Criteria) this;
        }

        public Criteria andShowHeightLike(String value) {
            addCriterion("show_height like", value, "showHeight");
            return (Criteria) this;
        }

        public Criteria andShowHeightNotLike(String value) {
            addCriterion("show_height not like", value, "showHeight");
            return (Criteria) this;
        }

        public Criteria andShowHeightIn(List<String> values) {
            addCriterion("show_height in", values, "showHeight");
            return (Criteria) this;
        }

        public Criteria andShowHeightNotIn(List<String> values) {
            addCriterion("show_height not in", values, "showHeight");
            return (Criteria) this;
        }

        public Criteria andShowHeightBetween(String value1, String value2) {
            addCriterion("show_height between", value1, value2, "showHeight");
            return (Criteria) this;
        }

        public Criteria andShowHeightNotBetween(String value1, String value2) {
            addCriterion("show_height not between", value1, value2, "showHeight");
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