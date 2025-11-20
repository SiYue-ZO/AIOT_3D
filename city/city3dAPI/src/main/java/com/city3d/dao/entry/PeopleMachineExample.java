package com.city3d.dao.entry;

import java.util.ArrayList;
import java.util.List;

public class PeopleMachineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PeopleMachineExample() {
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

        public Criteria andMachineIdIsNull() {
            addCriterion("machine_id is null");
            return (Criteria) this;
        }

        public Criteria andMachineIdIsNotNull() {
            addCriterion("machine_id is not null");
            return (Criteria) this;
        }

        public Criteria andMachineIdEqualTo(String value) {
            addCriterion("machine_id =", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdNotEqualTo(String value) {
            addCriterion("machine_id <>", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdGreaterThan(String value) {
            addCriterion("machine_id >", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdGreaterThanOrEqualTo(String value) {
            addCriterion("machine_id >=", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdLessThan(String value) {
            addCriterion("machine_id <", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdLessThanOrEqualTo(String value) {
            addCriterion("machine_id <=", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdLike(String value) {
            addCriterion("machine_id like", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdNotLike(String value) {
            addCriterion("machine_id not like", value, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdIn(List<String> values) {
            addCriterion("machine_id in", values, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdNotIn(List<String> values) {
            addCriterion("machine_id not in", values, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdBetween(String value1, String value2) {
            addCriterion("machine_id between", value1, value2, "machineId");
            return (Criteria) this;
        }

        public Criteria andMachineIdNotBetween(String value1, String value2) {
            addCriterion("machine_id not between", value1, value2, "machineId");
            return (Criteria) this;
        }

        public Criteria andPpIdIsNull() {
            addCriterion("pp_id is null");
            return (Criteria) this;
        }

        public Criteria andPpIdIsNotNull() {
            addCriterion("pp_id is not null");
            return (Criteria) this;
        }

        public Criteria andPpIdEqualTo(String value) {
            addCriterion("pp_id =", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotEqualTo(String value) {
            addCriterion("pp_id <>", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdGreaterThan(String value) {
            addCriterion("pp_id >", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdGreaterThanOrEqualTo(String value) {
            addCriterion("pp_id >=", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLessThan(String value) {
            addCriterion("pp_id <", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLessThanOrEqualTo(String value) {
            addCriterion("pp_id <=", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdLike(String value) {
            addCriterion("pp_id like", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotLike(String value) {
            addCriterion("pp_id not like", value, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdIn(List<String> values) {
            addCriterion("pp_id in", values, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotIn(List<String> values) {
            addCriterion("pp_id not in", values, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdBetween(String value1, String value2) {
            addCriterion("pp_id between", value1, value2, "ppId");
            return (Criteria) this;
        }

        public Criteria andPpIdNotBetween(String value1, String value2) {
            addCriterion("pp_id not between", value1, value2, "ppId");
            return (Criteria) this;
        }

        public Criteria andQrCodeIsNull() {
            addCriterion("qr_code is null");
            return (Criteria) this;
        }

        public Criteria andQrCodeIsNotNull() {
            addCriterion("qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andQrCodeEqualTo(String value) {
            addCriterion("qr_code =", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotEqualTo(String value) {
            addCriterion("qr_code <>", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThan(String value) {
            addCriterion("qr_code >", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("qr_code >=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThan(String value) {
            addCriterion("qr_code <", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThanOrEqualTo(String value) {
            addCriterion("qr_code <=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLike(String value) {
            addCriterion("qr_code like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotLike(String value) {
            addCriterion("qr_code not like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeIn(List<String> values) {
            addCriterion("qr_code in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotIn(List<String> values) {
            addCriterion("qr_code not in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeBetween(String value1, String value2) {
            addCriterion("qr_code between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotBetween(String value1, String value2) {
            addCriterion("qr_code not between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlIsNull() {
            addCriterion("machine_img_url is null");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlIsNotNull() {
            addCriterion("machine_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlEqualTo(String value) {
            addCriterion("machine_img_url =", value, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlNotEqualTo(String value) {
            addCriterion("machine_img_url <>", value, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlGreaterThan(String value) {
            addCriterion("machine_img_url >", value, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("machine_img_url >=", value, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlLessThan(String value) {
            addCriterion("machine_img_url <", value, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlLessThanOrEqualTo(String value) {
            addCriterion("machine_img_url <=", value, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlLike(String value) {
            addCriterion("machine_img_url like", value, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlNotLike(String value) {
            addCriterion("machine_img_url not like", value, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlIn(List<String> values) {
            addCriterion("machine_img_url in", values, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlNotIn(List<String> values) {
            addCriterion("machine_img_url not in", values, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlBetween(String value1, String value2) {
            addCriterion("machine_img_url between", value1, value2, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineImgUrlNotBetween(String value1, String value2) {
            addCriterion("machine_img_url not between", value1, value2, "machineImgUrl");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkIsNull() {
            addCriterion("machine_remark is null");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkIsNotNull() {
            addCriterion("machine_remark is not null");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkEqualTo(String value) {
            addCriterion("machine_remark =", value, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkNotEqualTo(String value) {
            addCriterion("machine_remark <>", value, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkGreaterThan(String value) {
            addCriterion("machine_remark >", value, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("machine_remark >=", value, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkLessThan(String value) {
            addCriterion("machine_remark <", value, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkLessThanOrEqualTo(String value) {
            addCriterion("machine_remark <=", value, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkLike(String value) {
            addCriterion("machine_remark like", value, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkNotLike(String value) {
            addCriterion("machine_remark not like", value, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkIn(List<String> values) {
            addCriterion("machine_remark in", values, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkNotIn(List<String> values) {
            addCriterion("machine_remark not in", values, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkBetween(String value1, String value2) {
            addCriterion("machine_remark between", value1, value2, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineRemarkNotBetween(String value1, String value2) {
            addCriterion("machine_remark not between", value1, value2, "machineRemark");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIsNull() {
            addCriterion("machine_type is null");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIsNotNull() {
            addCriterion("machine_type is not null");
            return (Criteria) this;
        }

        public Criteria andMachineTypeEqualTo(String value) {
            addCriterion("machine_type =", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotEqualTo(String value) {
            addCriterion("machine_type <>", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeGreaterThan(String value) {
            addCriterion("machine_type >", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeGreaterThanOrEqualTo(String value) {
            addCriterion("machine_type >=", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeLessThan(String value) {
            addCriterion("machine_type <", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeLessThanOrEqualTo(String value) {
            addCriterion("machine_type <=", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeLike(String value) {
            addCriterion("machine_type like", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotLike(String value) {
            addCriterion("machine_type not like", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIn(List<String> values) {
            addCriterion("machine_type in", values, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotIn(List<String> values) {
            addCriterion("machine_type not in", values, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeBetween(String value1, String value2) {
            addCriterion("machine_type between", value1, value2, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotBetween(String value1, String value2) {
            addCriterion("machine_type not between", value1, value2, "machineType");
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