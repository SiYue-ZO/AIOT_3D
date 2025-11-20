package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class SysFuncExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysFuncExample() {
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

        public Criteria andFuncIdIsNull() {
            addCriterion("func_id is null");
            return (Criteria) this;
        }

        public Criteria andFuncIdIsNotNull() {
            addCriterion("func_id is not null");
            return (Criteria) this;
        }

        public Criteria andFuncIdEqualTo(String value) {
            addCriterion("func_id =", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotEqualTo(String value) {
            addCriterion("func_id <>", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdGreaterThan(String value) {
            addCriterion("func_id >", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdGreaterThanOrEqualTo(String value) {
            addCriterion("func_id >=", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLessThan(String value) {
            addCriterion("func_id <", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLessThanOrEqualTo(String value) {
            addCriterion("func_id <=", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLike(String value) {
            addCriterion("func_id like", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotLike(String value) {
            addCriterion("func_id not like", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdIn(List<String> values) {
            addCriterion("func_id in", values, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotIn(List<String> values) {
            addCriterion("func_id not in", values, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdBetween(String value1, String value2) {
            addCriterion("func_id between", value1, value2, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotBetween(String value1, String value2) {
            addCriterion("func_id not between", value1, value2, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIsNull() {
            addCriterion("func_url is null");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIsNotNull() {
            addCriterion("func_url is not null");
            return (Criteria) this;
        }

        public Criteria andFuncUrlEqualTo(String value) {
            addCriterion("func_url =", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotEqualTo(String value) {
            addCriterion("func_url <>", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlGreaterThan(String value) {
            addCriterion("func_url >", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlGreaterThanOrEqualTo(String value) {
            addCriterion("func_url >=", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLessThan(String value) {
            addCriterion("func_url <", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLessThanOrEqualTo(String value) {
            addCriterion("func_url <=", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLike(String value) {
            addCriterion("func_url like", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotLike(String value) {
            addCriterion("func_url not like", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIn(List<String> values) {
            addCriterion("func_url in", values, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotIn(List<String> values) {
            addCriterion("func_url not in", values, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlBetween(String value1, String value2) {
            addCriterion("func_url between", value1, value2, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotBetween(String value1, String value2) {
            addCriterion("func_url not between", value1, value2, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameIsNull() {
            addCriterion("func_iot_name is null");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameIsNotNull() {
            addCriterion("func_iot_name is not null");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameEqualTo(String value) {
            addCriterion("func_iot_name =", value, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameNotEqualTo(String value) {
            addCriterion("func_iot_name <>", value, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameGreaterThan(String value) {
            addCriterion("func_iot_name >", value, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameGreaterThanOrEqualTo(String value) {
            addCriterion("func_iot_name >=", value, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameLessThan(String value) {
            addCriterion("func_iot_name <", value, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameLessThanOrEqualTo(String value) {
            addCriterion("func_iot_name <=", value, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameLike(String value) {
            addCriterion("func_iot_name like", value, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameNotLike(String value) {
            addCriterion("func_iot_name not like", value, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameIn(List<String> values) {
            addCriterion("func_iot_name in", values, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameNotIn(List<String> values) {
            addCriterion("func_iot_name not in", values, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameBetween(String value1, String value2) {
            addCriterion("func_iot_name between", value1, value2, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotNameNotBetween(String value1, String value2) {
            addCriterion("func_iot_name not between", value1, value2, "funcIotName");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgIsNull() {
            addCriterion("func_iot_img is null");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgIsNotNull() {
            addCriterion("func_iot_img is not null");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgEqualTo(String value) {
            addCriterion("func_iot_img =", value, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgNotEqualTo(String value) {
            addCriterion("func_iot_img <>", value, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgGreaterThan(String value) {
            addCriterion("func_iot_img >", value, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgGreaterThanOrEqualTo(String value) {
            addCriterion("func_iot_img >=", value, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgLessThan(String value) {
            addCriterion("func_iot_img <", value, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgLessThanOrEqualTo(String value) {
            addCriterion("func_iot_img <=", value, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgLike(String value) {
            addCriterion("func_iot_img like", value, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgNotLike(String value) {
            addCriterion("func_iot_img not like", value, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgIn(List<String> values) {
            addCriterion("func_iot_img in", values, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgNotIn(List<String> values) {
            addCriterion("func_iot_img not in", values, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgBetween(String value1, String value2) {
            addCriterion("func_iot_img between", value1, value2, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncIotImgNotBetween(String value1, String value2) {
            addCriterion("func_iot_img not between", value1, value2, "funcIotImg");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIsNull() {
            addCriterion("func_type is null");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIsNotNull() {
            addCriterion("func_type is not null");
            return (Criteria) this;
        }

        public Criteria andFuncTypeEqualTo(String value) {
            addCriterion("func_type =", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotEqualTo(String value) {
            addCriterion("func_type <>", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeGreaterThan(String value) {
            addCriterion("func_type >", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeGreaterThanOrEqualTo(String value) {
            addCriterion("func_type >=", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLessThan(String value) {
            addCriterion("func_type <", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLessThanOrEqualTo(String value) {
            addCriterion("func_type <=", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLike(String value) {
            addCriterion("func_type like", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotLike(String value) {
            addCriterion("func_type not like", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIn(List<String> values) {
            addCriterion("func_type in", values, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotIn(List<String> values) {
            addCriterion("func_type not in", values, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeBetween(String value1, String value2) {
            addCriterion("func_type between", value1, value2, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotBetween(String value1, String value2) {
            addCriterion("func_type not between", value1, value2, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncSrcIsNull() {
            addCriterion("func_src is null");
            return (Criteria) this;
        }

        public Criteria andFuncSrcIsNotNull() {
            addCriterion("func_src is not null");
            return (Criteria) this;
        }

        public Criteria andFuncSrcEqualTo(String value) {
            addCriterion("func_src =", value, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncSrcNotEqualTo(String value) {
            addCriterion("func_src <>", value, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncSrcGreaterThan(String value) {
            addCriterion("func_src >", value, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncSrcGreaterThanOrEqualTo(String value) {
            addCriterion("func_src >=", value, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncSrcLessThan(String value) {
            addCriterion("func_src <", value, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncSrcLessThanOrEqualTo(String value) {
            addCriterion("func_src <=", value, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncSrcLike(String value) {
            addCriterion("func_src like", value, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncSrcNotLike(String value) {
            addCriterion("func_src not like", value, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncSrcIn(List<String> values) {
            addCriterion("func_src in", values, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncSrcNotIn(List<String> values) {
            addCriterion("func_src not in", values, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncSrcBetween(String value1, String value2) {
            addCriterion("func_src between", value1, value2, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncSrcNotBetween(String value1, String value2) {
            addCriterion("func_src not between", value1, value2, "funcSrc");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameIsNull() {
            addCriterion("func_default_name is null");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameIsNotNull() {
            addCriterion("func_default_name is not null");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameEqualTo(String value) {
            addCriterion("func_default_name =", value, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameNotEqualTo(String value) {
            addCriterion("func_default_name <>", value, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameGreaterThan(String value) {
            addCriterion("func_default_name >", value, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameGreaterThanOrEqualTo(String value) {
            addCriterion("func_default_name >=", value, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameLessThan(String value) {
            addCriterion("func_default_name <", value, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameLessThanOrEqualTo(String value) {
            addCriterion("func_default_name <=", value, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameLike(String value) {
            addCriterion("func_default_name like", value, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameNotLike(String value) {
            addCriterion("func_default_name not like", value, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameIn(List<String> values) {
            addCriterion("func_default_name in", values, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameNotIn(List<String> values) {
            addCriterion("func_default_name not in", values, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameBetween(String value1, String value2) {
            addCriterion("func_default_name between", value1, value2, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncDefaultNameNotBetween(String value1, String value2) {
            addCriterion("func_default_name not between", value1, value2, "funcDefaultName");
            return (Criteria) this;
        }

        public Criteria andFuncPidIsNull() {
            addCriterion("func_pid is null");
            return (Criteria) this;
        }

        public Criteria andFuncPidIsNotNull() {
            addCriterion("func_pid is not null");
            return (Criteria) this;
        }

        public Criteria andFuncPidEqualTo(String value) {
            addCriterion("func_pid =", value, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncPidNotEqualTo(String value) {
            addCriterion("func_pid <>", value, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncPidGreaterThan(String value) {
            addCriterion("func_pid >", value, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncPidGreaterThanOrEqualTo(String value) {
            addCriterion("func_pid >=", value, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncPidLessThan(String value) {
            addCriterion("func_pid <", value, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncPidLessThanOrEqualTo(String value) {
            addCriterion("func_pid <=", value, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncPidLike(String value) {
            addCriterion("func_pid like", value, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncPidNotLike(String value) {
            addCriterion("func_pid not like", value, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncPidIn(List<String> values) {
            addCriterion("func_pid in", values, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncPidNotIn(List<String> values) {
            addCriterion("func_pid not in", values, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncPidBetween(String value1, String value2) {
            addCriterion("func_pid between", value1, value2, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncPidNotBetween(String value1, String value2) {
            addCriterion("func_pid not between", value1, value2, "funcPid");
            return (Criteria) this;
        }

        public Criteria andFuncLevelIsNull() {
            addCriterion("func_level is null");
            return (Criteria) this;
        }

        public Criteria andFuncLevelIsNotNull() {
            addCriterion("func_level is not null");
            return (Criteria) this;
        }

        public Criteria andFuncLevelEqualTo(String value) {
            addCriterion("func_level =", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelNotEqualTo(String value) {
            addCriterion("func_level <>", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelGreaterThan(String value) {
            addCriterion("func_level >", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelGreaterThanOrEqualTo(String value) {
            addCriterion("func_level >=", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelLessThan(String value) {
            addCriterion("func_level <", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelLessThanOrEqualTo(String value) {
            addCriterion("func_level <=", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelLike(String value) {
            addCriterion("func_level like", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelNotLike(String value) {
            addCriterion("func_level not like", value, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelIn(List<String> values) {
            addCriterion("func_level in", values, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelNotIn(List<String> values) {
            addCriterion("func_level not in", values, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelBetween(String value1, String value2) {
            addCriterion("func_level between", value1, value2, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncLevelNotBetween(String value1, String value2) {
            addCriterion("func_level not between", value1, value2, "funcLevel");
            return (Criteria) this;
        }

        public Criteria andFuncIconIsNull() {
            addCriterion("func_icon is null");
            return (Criteria) this;
        }

        public Criteria andFuncIconIsNotNull() {
            addCriterion("func_icon is not null");
            return (Criteria) this;
        }

        public Criteria andFuncIconEqualTo(String value) {
            addCriterion("func_icon =", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconNotEqualTo(String value) {
            addCriterion("func_icon <>", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconGreaterThan(String value) {
            addCriterion("func_icon >", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconGreaterThanOrEqualTo(String value) {
            addCriterion("func_icon >=", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconLessThan(String value) {
            addCriterion("func_icon <", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconLessThanOrEqualTo(String value) {
            addCriterion("func_icon <=", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconLike(String value) {
            addCriterion("func_icon like", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconNotLike(String value) {
            addCriterion("func_icon not like", value, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconIn(List<String> values) {
            addCriterion("func_icon in", values, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconNotIn(List<String> values) {
            addCriterion("func_icon not in", values, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconBetween(String value1, String value2) {
            addCriterion("func_icon between", value1, value2, "funcIcon");
            return (Criteria) this;
        }

        public Criteria andFuncIconNotBetween(String value1, String value2) {
            addCriterion("func_icon not between", value1, value2, "funcIcon");
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