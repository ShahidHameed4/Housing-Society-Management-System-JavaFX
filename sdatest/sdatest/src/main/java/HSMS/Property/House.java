package HSMS.Property;

import HSMS.Resident.Owner;
import HSMS.Resident.Resident;

import java.util.ArrayList;

public class House extends Property{
 private String hNo;
 private String blockN;
 private String desc;
 private String type;

 private int rCNIC;
 private int oCNIC;


 public int getrCNIC() {
  return rCNIC;
 }

 public int getoCNIC() {
  return oCNIC;
 }

 public void setrCNIC(int rCNIC) {
  this.rCNIC = rCNIC;
 }

 public void setoCNIC(int oCNIC) {
  this.oCNIC = oCNIC;
 }

 public String gethNo() {
  return hNo;
 }

 public void sethNo(String hNo) {
  this.hNo = hNo;
 }

 public String getBlockN() {
  return blockN;
 }

 public void setBlockN(String blockN) {
  this.blockN = blockN;
 }

 public String getDesc() {
  return desc;
 }

 public void setDesc(String desc) {
  this.desc = desc;
 }

 public String getType() {
  return type;
 }

 public void setType(String type) {
  this.type = type;
 }

 public House() {
 }

 public House( String hNo, String blockN, String desc, String type) {
  this.hNo = hNo;
  this.blockN = blockN;
  this.desc = desc;
  this.type = type;
 }

// public Owner getOwner() {
//  return owner;
// }
//
// public void setOwner(Owner owner) {
//  this.owner = owner;
// }

// public Resident getResident() {
//  return resident;
// }
//
// public void setResident(Resident resident) {
//  this.resident = resident;
// }

 public int assignID(ArrayList<House> houses){
  int t = 0;
  boolean check = false;
  while(!check){
   t = genID();
   if(!exists(t,houses)){
    System.out.println("house "+t);
    return t;
   }
  }
  return t;
 }

 public int genID(){
  int min = 10000;
  int max = 20000;

  int tempID = (int)(Math.random()*(max-min+1)+min);

  return tempID;
 }

 public boolean exists(int ID,ArrayList<House> houses){
  for(House a: houses){
   if (a.hNo.equals(Integer.toString(ID)))
    return true;
  }

  return false;
 }



// public void addHouse(String block,String Desc,String type,ArrayList<House> obj){
//
// obj.add(new House(block,Desc,type));
// }








}
