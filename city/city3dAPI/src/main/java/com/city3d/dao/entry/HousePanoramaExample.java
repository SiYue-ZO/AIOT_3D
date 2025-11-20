package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class HousePanoramaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HousePanoramaExample() {
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

        public Criteria andPanoramaIdIsNull() {
            addCriterion("panorama_id is null");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdIsNotNull() {
            addCriterion("panorama_id is not null");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdEqualTo(String value) {
            addCriterion("panorama_id =", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdNotEqualTo(String value) {
            addCriterion("panorama_id <>", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdGreaterThan(String value) {
            addCriterion("panorama_id >", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdGreaterThanOrEqualTo(String value) {
            addCriterion("panorama_id >=", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdLessThan(String value) {
            addCriterion("panorama_id <", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdLessThanOrEqualTo(String value) {
            addCriterion("panorama_id <=", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdLike(String value) {
            addCriterion("panorama_id like", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdNotLike(String value) {
            addCriterion("panorama_id not like", value, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdIn(List<String> values) {
            addCriterion("panorama_id in", values, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdNotIn(List<String> values) {
            addCriterion("panorama_id not in", values, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdBetween(String value1, String value2) {
            addCriterion("panorama_id between", value1, value2, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andPanoramaIdNotBetween(String value1, String value2) {
            addCriterion("panorama_id not between", value1, value2, "panoramaId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNull() {
            addCriterion("house_id is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNotNull() {
            addCriterion("house_id is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdEqualTo(String value) {
            addCriterion("house_id =", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotEqualTo(String value) {
            addCriterion("house_id <>", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThan(String value) {
            addCriterion("house_id >", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("house_id >=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThan(String value) {
            addCriterion("house_id <", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThanOrEqualTo(String value) {
            addCriterion("house_id <=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLike(String value) {
            addCriterion("house_id like", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotLike(String value) {
            addCriterion("house_id not like", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIn(List<String> values) {
            addCriterion("house_id in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotIn(List<String> values) {
            addCriterion("house_id not in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdBetween(String value1, String value2) {
            addCriterion("house_id between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotBetween(String value1, String value2) {
            addCriterion("house_id not between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaIsNull() {
            addCriterion("house_panorama is null");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaIsNotNull() {
            addCriterion("house_panorama is not null");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaEqualTo(String value) {
            addCriterion("house_panorama =", value, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaNotEqualTo(String value) {
            addCriterion("house_panorama <>", value, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaGreaterThan(String value) {
            addCriterion("house_panorama >", value, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaGreaterThanOrEqualTo(String value) {
            addCriterion("house_panorama >=", value, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaLessThan(String value) {
            addCriterion("house_panorama <", value, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaLessThanOrEqualTo(String value) {
            addCriterion("house_panorama <=", value, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaLike(String value) {
            addCriterion("house_panorama like", value, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaNotLike(String value) {
            addCriterion("house_panorama not like", value, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaIn(List<String> values) {
            addCriterion("house_panorama in", values, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaNotIn(List<String> values) {
            addCriterion("house_panorama not in", values, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaBetween(String value1, String value2) {
            addCriterion("house_panorama between", value1, value2, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePanoramaNotBetween(String value1, String value2) {
            addCriterion("house_panorama not between", value1, value2, "housePanorama");
            return (Criteria) this;
        }

        public Criteria andHousePatternIsNull() {
            addCriterion("house_pattern is null");
            return (Criteria) this;
        }

        public Criteria andHousePatternIsNotNull() {
            addCriterion("house_pattern is not null");
            return (Criteria) this;
        }

        public Criteria andHousePatternEqualTo(String value) {
            addCriterion("house_pattern =", value, "housePattern");
            return (Criteria) this;
        }

        public Criteria andHousePatternNotEqualTo(String value) {
            addCriterion("house_pattern <>", value, "housePattern");
            return (Criteria) this;
        }

        public Criteria andHousePatternGreaterThan(String value) {
            addCriterion("house_pattern >", value, "housePattern");
            return (Criteria) this;
        }

        public Criteria andHousePatternGreaterThanOrEqualTo(String value) {
            addCriterion("house_pattern >=", value, "housePattern");
            return (Criteria) this;
        }

        public Criteria andHousePatternLessThan(String value) {
            addCriterion("house_pattern <", value, "housePattern");
            return (Criteria) this;
        }

        public Criteria andHousePatternLessThanOrEqualTo(String value) {
            addCriterion("house_pattern <=", value, "housePattern");
            return (Criteria) this;
        }

        public Criteria andHousePatternLike(String value) {
            addCriterion("house_pattern like", value, "housePattern");
            return (Criteria) this;
        }

        public Criteria andHousePatternNotLike(String value) {
            addCriterion("house_pattern not like", value, "housePattern");
            return (Criteria) this;
        }

        public Criteria andHousePatternIn(List<String> values) {
            addCriterion("house_pattern in", values, "housePattern");
            return (Criteria) this;
        }

        public Criteria andHousePatternNotIn(List<String> values) {
            addCriterion("house_pattern not in", values, "housePattern");
            return (Criteria) this;
        }

        public Criteria andHousePatternBetween(String value1, String value2) {
            addCriterion("house_pattern between", value1, value2, "housePattern");
            return (Criteria) this;
        }

        public Criteria andHousePatternNotBetween(String value1, String value2) {
            addCriterion("house_pattern not between", value1, value2, "housePattern");
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