package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class MapImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MapImageExample() {
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

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(String value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(String value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(String value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(String value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(String value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLike(String value) {
            addCriterion("image_id like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotLike(String value) {
            addCriterion("image_id not like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<String> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<String> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(String value1, String value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(String value1, String value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageNameIsNull() {
            addCriterion("image_name is null");
            return (Criteria) this;
        }

        public Criteria andImageNameIsNotNull() {
            addCriterion("image_name is not null");
            return (Criteria) this;
        }

        public Criteria andImageNameEqualTo(String value) {
            addCriterion("image_name =", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotEqualTo(String value) {
            addCriterion("image_name <>", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameGreaterThan(String value) {
            addCriterion("image_name >", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameGreaterThanOrEqualTo(String value) {
            addCriterion("image_name >=", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLessThan(String value) {
            addCriterion("image_name <", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLessThanOrEqualTo(String value) {
            addCriterion("image_name <=", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameLike(String value) {
            addCriterion("image_name like", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotLike(String value) {
            addCriterion("image_name not like", value, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameIn(List<String> values) {
            addCriterion("image_name in", values, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotIn(List<String> values) {
            addCriterion("image_name not in", values, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameBetween(String value1, String value2) {
            addCriterion("image_name between", value1, value2, "imageName");
            return (Criteria) this;
        }

        public Criteria andImageNameNotBetween(String value1, String value2) {
            addCriterion("image_name not between", value1, value2, "imageName");
            return (Criteria) this;
        }

        public Criteria andImagePosIsNull() {
            addCriterion("image_pos is null");
            return (Criteria) this;
        }

        public Criteria andImagePosIsNotNull() {
            addCriterion("image_pos is not null");
            return (Criteria) this;
        }

        public Criteria andImagePosEqualTo(String value) {
            addCriterion("image_pos =", value, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImagePosNotEqualTo(String value) {
            addCriterion("image_pos <>", value, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImagePosGreaterThan(String value) {
            addCriterion("image_pos >", value, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImagePosGreaterThanOrEqualTo(String value) {
            addCriterion("image_pos >=", value, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImagePosLessThan(String value) {
            addCriterion("image_pos <", value, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImagePosLessThanOrEqualTo(String value) {
            addCriterion("image_pos <=", value, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImagePosLike(String value) {
            addCriterion("image_pos like", value, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImagePosNotLike(String value) {
            addCriterion("image_pos not like", value, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImagePosIn(List<String> values) {
            addCriterion("image_pos in", values, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImagePosNotIn(List<String> values) {
            addCriterion("image_pos not in", values, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImagePosBetween(String value1, String value2) {
            addCriterion("image_pos between", value1, value2, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImagePosNotBetween(String value1, String value2) {
            addCriterion("image_pos not between", value1, value2, "imagePos");
            return (Criteria) this;
        }

        public Criteria andImageTimeIsNull() {
            addCriterion("image_time is null");
            return (Criteria) this;
        }

        public Criteria andImageTimeIsNotNull() {
            addCriterion("image_time is not null");
            return (Criteria) this;
        }

        public Criteria andImageTimeEqualTo(String value) {
            addCriterion("image_time =", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeNotEqualTo(String value) {
            addCriterion("image_time <>", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeGreaterThan(String value) {
            addCriterion("image_time >", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeGreaterThanOrEqualTo(String value) {
            addCriterion("image_time >=", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeLessThan(String value) {
            addCriterion("image_time <", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeLessThanOrEqualTo(String value) {
            addCriterion("image_time <=", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeLike(String value) {
            addCriterion("image_time like", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeNotLike(String value) {
            addCriterion("image_time not like", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeIn(List<String> values) {
            addCriterion("image_time in", values, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeNotIn(List<String> values) {
            addCriterion("image_time not in", values, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeBetween(String value1, String value2) {
            addCriterion("image_time between", value1, value2, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeNotBetween(String value1, String value2) {
            addCriterion("image_time not between", value1, value2, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImagePidIsNull() {
            addCriterion("image_pid is null");
            return (Criteria) this;
        }

        public Criteria andImagePidIsNotNull() {
            addCriterion("image_pid is not null");
            return (Criteria) this;
        }

        public Criteria andImagePidEqualTo(String value) {
            addCriterion("image_pid =", value, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImagePidNotEqualTo(String value) {
            addCriterion("image_pid <>", value, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImagePidGreaterThan(String value) {
            addCriterion("image_pid >", value, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImagePidGreaterThanOrEqualTo(String value) {
            addCriterion("image_pid >=", value, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImagePidLessThan(String value) {
            addCriterion("image_pid <", value, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImagePidLessThanOrEqualTo(String value) {
            addCriterion("image_pid <=", value, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImagePidLike(String value) {
            addCriterion("image_pid like", value, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImagePidNotLike(String value) {
            addCriterion("image_pid not like", value, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImagePidIn(List<String> values) {
            addCriterion("image_pid in", values, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImagePidNotIn(List<String> values) {
            addCriterion("image_pid not in", values, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImagePidBetween(String value1, String value2) {
            addCriterion("image_pid between", value1, value2, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImagePidNotBetween(String value1, String value2) {
            addCriterion("image_pid not between", value1, value2, "imagePid");
            return (Criteria) this;
        }

        public Criteria andImageTypeIsNull() {
            addCriterion("image_type is null");
            return (Criteria) this;
        }

        public Criteria andImageTypeIsNotNull() {
            addCriterion("image_type is not null");
            return (Criteria) this;
        }

        public Criteria andImageTypeEqualTo(String value) {
            addCriterion("image_type =", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotEqualTo(String value) {
            addCriterion("image_type <>", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeGreaterThan(String value) {
            addCriterion("image_type >", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("image_type >=", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLessThan(String value) {
            addCriterion("image_type <", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLessThanOrEqualTo(String value) {
            addCriterion("image_type <=", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLike(String value) {
            addCriterion("image_type like", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotLike(String value) {
            addCriterion("image_type not like", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeIn(List<String> values) {
            addCriterion("image_type in", values, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotIn(List<String> values) {
            addCriterion("image_type not in", values, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeBetween(String value1, String value2) {
            addCriterion("image_type between", value1, value2, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotBetween(String value1, String value2) {
            addCriterion("image_type not between", value1, value2, "imageType");
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