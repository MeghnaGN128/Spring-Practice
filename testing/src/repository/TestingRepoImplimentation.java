package repository;

import dto.TestingDto;

public class TestingRepoImplimentation implements TestingRepo {
    @Override
    public boolean save(TestingDto testingDto) {
        if(testingDto!=null){
            String url="jdbc:mysql://localhost:3306/testing";
            String username="root";
            String password="Meghna@";

            return true;
        }
        return false;
    }
}
