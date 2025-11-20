package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class PipelineCheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PipelineCheckExample() {
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

        public Criteria andCheckIdIsNull() {
            addCriterion("check_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNotNull() {
            addCriterion("check_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckIdEqualTo(String value) {
            addCriterion("check_id =", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotEqualTo(String value) {
            addCriterion("check_id <>", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThan(String value) {
            addCriterion("check_id >", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThanOrEqualTo(String value) {
            addCriterion("check_id >=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThan(String value) {
            addCriterion("check_id <", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThanOrEqualTo(String value) {
            addCriterion("check_id <=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLike(String value) {
            addCriterion("check_id like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotLike(String value) {
            addCriterion("check_id not like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdIn(List<String> values) {
            addCriterion("check_id in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotIn(List<String> values) {
            addCriterion("check_id not in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdBetween(String value1, String value2) {
            addCriterion("check_id between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotBetween(String value1, String value2) {
            addCriterion("check_id not between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckAddIsNull() {
            addCriterion("check_add is null");
            return (Criteria) this;
        }

        public Criteria andCheckAddIsNotNull() {
            addCriterion("check_add is not null");
            return (Criteria) this;
        }

        public Criteria andCheckAddEqualTo(String value) {
            addCriterion("check_add =", value, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckAddNotEqualTo(String value) {
            addCriterion("check_add <>", value, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckAddGreaterThan(String value) {
            addCriterion("check_add >", value, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckAddGreaterThanOrEqualTo(String value) {
            addCriterion("check_add >=", value, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckAddLessThan(String value) {
            addCriterion("check_add <", value, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckAddLessThanOrEqualTo(String value) {
            addCriterion("check_add <=", value, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckAddLike(String value) {
            addCriterion("check_add like", value, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckAddNotLike(String value) {
            addCriterion("check_add not like", value, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckAddIn(List<String> values) {
            addCriterion("check_add in", values, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckAddNotIn(List<String> values) {
            addCriterion("check_add not in", values, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckAddBetween(String value1, String value2) {
            addCriterion("check_add between", value1, value2, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckAddNotBetween(String value1, String value2) {
            addCriterion("check_add not between", value1, value2, "checkAdd");
            return (Criteria) this;
        }

        public Criteria andCheckManIsNull() {
            addCriterion("check_man is null");
            return (Criteria) this;
        }

        public Criteria andCheckManIsNotNull() {
            addCriterion("check_man is not null");
            return (Criteria) this;
        }

        public Criteria andCheckManEqualTo(String value) {
            addCriterion("check_man =", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManNotEqualTo(String value) {
            addCriterion("check_man <>", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManGreaterThan(String value) {
            addCriterion("check_man >", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManGreaterThanOrEqualTo(String value) {
            addCriterion("check_man >=", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManLessThan(String value) {
            addCriterion("check_man <", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManLessThanOrEqualTo(String value) {
            addCriterion("check_man <=", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManLike(String value) {
            addCriterion("check_man like", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManNotLike(String value) {
            addCriterion("check_man not like", value, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManIn(List<String> values) {
            addCriterion("check_man in", values, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManNotIn(List<String> values) {
            addCriterion("check_man not in", values, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManBetween(String value1, String value2) {
            addCriterion("check_man between", value1, value2, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckManNotBetween(String value1, String value2) {
            addCriterion("check_man not between", value1, value2, "checkMan");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(String value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(String value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(String value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(String value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(String value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(String value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLike(String value) {
            addCriterion("check_time like", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotLike(String value) {
            addCriterion("check_time not like", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<String> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<String> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(String value1, String value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(String value1, String value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNull() {
            addCriterion("check_result is null");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNotNull() {
            addCriterion("check_result is not null");
            return (Criteria) this;
        }

        public Criteria andCheckResultEqualTo(String value) {
            addCriterion("check_result =", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotEqualTo(String value) {
            addCriterion("check_result <>", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThan(String value) {
            addCriterion("check_result >", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThanOrEqualTo(String value) {
            addCriterion("check_result >=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThan(String value) {
            addCriterion("check_result <", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThanOrEqualTo(String value) {
            addCriterion("check_result <=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLike(String value) {
            addCriterion("check_result like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotLike(String value) {
            addCriterion("check_result not like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultIn(List<String> values) {
            addCriterion("check_result in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotIn(List<String> values) {
            addCriterion("check_result not in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultBetween(String value1, String value2) {
            addCriterion("check_result between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotBetween(String value1, String value2) {
            addCriterion("check_result not between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andRepairManIsNull() {
            addCriterion("repair_man is null");
            return (Criteria) this;
        }

        public Criteria andRepairManIsNotNull() {
            addCriterion("repair_man is not null");
            return (Criteria) this;
        }

        public Criteria andRepairManEqualTo(String value) {
            addCriterion("repair_man =", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManNotEqualTo(String value) {
            addCriterion("repair_man <>", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManGreaterThan(String value) {
            addCriterion("repair_man >", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManGreaterThanOrEqualTo(String value) {
            addCriterion("repair_man >=", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManLessThan(String value) {
            addCriterion("repair_man <", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManLessThanOrEqualTo(String value) {
            addCriterion("repair_man <=", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManLike(String value) {
            addCriterion("repair_man like", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManNotLike(String value) {
            addCriterion("repair_man not like", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManIn(List<String> values) {
            addCriterion("repair_man in", values, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManNotIn(List<String> values) {
            addCriterion("repair_man not in", values, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManBetween(String value1, String value2) {
            addCriterion("repair_man between", value1, value2, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManNotBetween(String value1, String value2) {
            addCriterion("repair_man not between", value1, value2, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNull() {
            addCriterion("repair_time is null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNotNull() {
            addCriterion("repair_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeEqualTo(String value) {
            addCriterion("repair_time =", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotEqualTo(String value) {
            addCriterion("repair_time <>", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThan(String value) {
            addCriterion("repair_time >", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThanOrEqualTo(String value) {
            addCriterion("repair_time >=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThan(String value) {
            addCriterion("repair_time <", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThanOrEqualTo(String value) {
            addCriterion("repair_time <=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLike(String value) {
            addCriterion("repair_time like", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotLike(String value) {
            addCriterion("repair_time not like", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIn(List<String> values) {
            addCriterion("repair_time in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotIn(List<String> values) {
            addCriterion("repair_time not in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeBetween(String value1, String value2) {
            addCriterion("repair_time between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotBetween(String value1, String value2) {
            addCriterion("repair_time not between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairResultIsNull() {
            addCriterion("repair_result is null");
            return (Criteria) this;
        }

        public Criteria andRepairResultIsNotNull() {
            addCriterion("repair_result is not null");
            return (Criteria) this;
        }

        public Criteria andRepairResultEqualTo(String value) {
            addCriterion("repair_result =", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotEqualTo(String value) {
            addCriterion("repair_result <>", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultGreaterThan(String value) {
            addCriterion("repair_result >", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultGreaterThanOrEqualTo(String value) {
            addCriterion("repair_result >=", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultLessThan(String value) {
            addCriterion("repair_result <", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultLessThanOrEqualTo(String value) {
            addCriterion("repair_result <=", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultLike(String value) {
            addCriterion("repair_result like", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotLike(String value) {
            addCriterion("repair_result not like", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultIn(List<String> values) {
            addCriterion("repair_result in", values, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotIn(List<String> values) {
            addCriterion("repair_result not in", values, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultBetween(String value1, String value2) {
            addCriterion("repair_result between", value1, value2, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotBetween(String value1, String value2) {
            addCriterion("repair_result not between", value1, value2, "repairResult");
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