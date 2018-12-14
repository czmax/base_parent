package com.max.code.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_user")
public class SysUser implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String login;

    private String password;

    @Column(name = "user_name")
    private String userName;

    private String address;

    private String job;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "birth_date")
    private Date birthDate;

    private String city;

    private String district;

    private String province;

    @Column(name = "street_address")
    private String streetAddress;

    private String state;

    private String type;

    @Column(name = "last_login_date")
    private Date lastLoginDate;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login
     */
    public void setLogin(String login) {
        this.login = login == null ? null : login.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job
     */
    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    /**
     * @return dept_id
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * @param deptId
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * @return birth_date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * @return street_address
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param streetAddress
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress == null ? null : streetAddress.trim();
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return last_login_date
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * @param lastLoginDate
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysUser other = (SysUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLogin() == null ? other.getLogin() == null : this.getLogin().equals(other.getLogin()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getJob() == null ? other.getJob() == null : this.getJob().equals(other.getJob()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getStreetAddress() == null ? other.getStreetAddress() == null : this.getStreetAddress().equals(other.getStreetAddress()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getLastLoginDate() == null ? other.getLastLoginDate() == null : this.getLastLoginDate().equals(other.getLastLoginDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLogin() == null) ? 0 : getLogin().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getJob() == null) ? 0 : getJob().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getStreetAddress() == null) ? 0 : getStreetAddress().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getLastLoginDate() == null) ? 0 : getLastLoginDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", login=").append(login);
        sb.append(", password=").append(password);
        sb.append(", userName=").append(userName);
        sb.append(", address=").append(address);
        sb.append(", job=").append(job);
        sb.append(", deptId=").append(deptId);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", province=").append(province);
        sb.append(", streetAddress=").append(streetAddress);
        sb.append(", state=").append(state);
        sb.append(", type=").append(type);
        sb.append(", lastLoginDate=").append(lastLoginDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}