package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class MapPhotosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MapPhotosExample() {
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

        public Criteria andPhotoIdIsNull() {
            addCriterion("photo_id is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIsNotNull() {
            addCriterion("photo_id is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdEqualTo(String value) {
            addCriterion("photo_id =", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotEqualTo(String value) {
            addCriterion("photo_id <>", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThan(String value) {
            addCriterion("photo_id >", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThanOrEqualTo(String value) {
            addCriterion("photo_id >=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThan(String value) {
            addCriterion("photo_id <", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThanOrEqualTo(String value) {
            addCriterion("photo_id <=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLike(String value) {
            addCriterion("photo_id like", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotLike(String value) {
            addCriterion("photo_id not like", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIn(List<String> values) {
            addCriterion("photo_id in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotIn(List<String> values) {
            addCriterion("photo_id not in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdBetween(String value1, String value2) {
            addCriterion("photo_id between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotBetween(String value1, String value2) {
            addCriterion("photo_id not between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIsNull() {
            addCriterion("photo_name is null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIsNotNull() {
            addCriterion("photo_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameEqualTo(String value) {
            addCriterion("photo_name =", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotEqualTo(String value) {
            addCriterion("photo_name <>", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThan(String value) {
            addCriterion("photo_name >", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThanOrEqualTo(String value) {
            addCriterion("photo_name >=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThan(String value) {
            addCriterion("photo_name <", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThanOrEqualTo(String value) {
            addCriterion("photo_name <=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLike(String value) {
            addCriterion("photo_name like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotLike(String value) {
            addCriterion("photo_name not like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIn(List<String> values) {
            addCriterion("photo_name in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotIn(List<String> values) {
            addCriterion("photo_name not in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameBetween(String value1, String value2) {
            addCriterion("photo_name between", value1, value2, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotBetween(String value1, String value2) {
            addCriterion("photo_name not between", value1, value2, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoPosIsNull() {
            addCriterion("photo_pos is null");
            return (Criteria) this;
        }

        public Criteria andPhotoPosIsNotNull() {
            addCriterion("photo_pos is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoPosEqualTo(String value) {
            addCriterion("photo_pos =", value, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoPosNotEqualTo(String value) {
            addCriterion("photo_pos <>", value, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoPosGreaterThan(String value) {
            addCriterion("photo_pos >", value, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoPosGreaterThanOrEqualTo(String value) {
            addCriterion("photo_pos >=", value, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoPosLessThan(String value) {
            addCriterion("photo_pos <", value, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoPosLessThanOrEqualTo(String value) {
            addCriterion("photo_pos <=", value, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoPosLike(String value) {
            addCriterion("photo_pos like", value, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoPosNotLike(String value) {
            addCriterion("photo_pos not like", value, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoPosIn(List<String> values) {
            addCriterion("photo_pos in", values, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoPosNotIn(List<String> values) {
            addCriterion("photo_pos not in", values, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoPosBetween(String value1, String value2) {
            addCriterion("photo_pos between", value1, value2, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoPosNotBetween(String value1, String value2) {
            addCriterion("photo_pos not between", value1, value2, "photoPos");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeIsNull() {
            addCriterion("photo_time is null");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeIsNotNull() {
            addCriterion("photo_time is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeEqualTo(String value) {
            addCriterion("photo_time =", value, "photoTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeNotEqualTo(String value) {
            addCriterion("photo_time <>", value, "photoTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeGreaterThan(String value) {
            addCriterion("photo_time >", value, "photoTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeGreaterThanOrEqualTo(String value) {
            addCriterion("photo_time >=", value, "photoTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeLessThan(String value) {
            addCriterion("photo_time <", value, "photoTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeLessThanOrEqualTo(String value) {
            addCriterion("photo_time <=", value, "photoTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeLike(String value) {
            addCriterion("photo_time like", value, "photoTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeNotLike(String value) {
            addCriterion("photo_time not like", value, "photoTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeIn(List<String> values) {
            addCriterion("photo_time in", values, "photoTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeNotIn(List<String> values) {
            addCriterion("photo_time not in", values, "photoTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeBetween(String value1, String value2) {
            addCriterion("photo_time between", value1, value2, "photoTime");
            return (Criteria) this;
        }

        public Criteria andPhotoTimeNotBetween(String value1, String value2) {
            addCriterion("photo_time not between", value1, value2, "photoTime");
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