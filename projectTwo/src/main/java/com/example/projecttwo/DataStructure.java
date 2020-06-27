package com.example.projecttwo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DataStructure {
    private @Id @GeneratedValue Long id;
    private String label;
    private Float insertionSort;
    private Float selectionSort;
    private Float quickSort;
    private Float mergeSort;
    private Float heapSort;
    private Float radixSort;

    DataStructure(){}
    DataStructure(String label, Float insertionSort, Float selectionSort, Float quickSort, Float mergeSort, Float heapSort, Float radixSort){
        this.label = label;
        this.insertionSort = insertionSort;
        this.selectionSort = selectionSort;
        this.quickSort = quickSort;
        this.mergeSort = mergeSort;
        this.heapSort = heapSort;
        this.radixSort = radixSort;
    }
    public String getLabel(){
        return label;
    }

    public void setLabel(String label){
        this.label = label;
    }
    public Float getInsertionSort(){
        return insertionSort;
    }
    public Float getSelectionSort(){
        return selectionSort;
    }
    public Float getQuickSort(){
        return quickSort;
    }
    public Float getMergeSort(){
        return mergeSort;
    }
    public Float getHeapSort() {
        return heapSort;
    }
    public Float getRadixSort(){
        return radixSort;
    }
    public void setInsertionSort(Float insertionSort){
        this.insertionSort = insertionSort;
    }
    public void setSelectionSort(Float selectionSort){
        this.selectionSort = selectionSort;
    }
    public void setQuickSort(Float quickSort){
        this.quickSort = quickSort;
    }
    public void setMergeSort(Float mergeSort){
        this.mergeSort = mergeSort;
    }
    public void setHeapSort(Float heapSort){
        this.heapSort = heapSort;
    }
    public void setRadixSort(Float radixSort){
        this.radixSort = radixSort;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof DataStructure))
            return false;
        DataStructure dataStructure = (DataStructure) o;
        return Objects.equals(this.id, dataStructure.label) && Objects.equals(this.label, dataStructure.label);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.label, this.insertionSort, this.selectionSort, this.quickSort, this.mergeSort, this.heapSort, this.radixSort);
    }
    @Override
    public String toString(){
        return "Label = " + this.label;
    }
}
