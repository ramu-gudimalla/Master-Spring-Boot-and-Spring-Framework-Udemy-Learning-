const person = { 
  name: "Ramu",
  address:{
    street:'Wall Street',
    city: 'USA'
  },
  profiles: ['twitter','instagram','facebook'],
  printProfile: ()=>{
    // console.log(person.profiles[1])
      person.profiles.map(
        (profile) => console.log(profile)
      )
  }
};
export default function LearningJavaScript() {
  return (
    <>
      <div>{person.name}</div>
      <div>{person.address.street}</div>
      <div>{person.address.city}</div>
      <div>{person.profiles[0]}</div>
      <div>{person.printProfile()}</div>
    </>
  );
}
