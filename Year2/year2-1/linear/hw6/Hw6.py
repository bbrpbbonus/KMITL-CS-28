import numpy as np

def main():
    data = np.array([[3.0, 3.0, -4.0, 3.0],
                     [1.0, -3.0, 2.0, 2.0],
                     [2.0, -1.0, -1.0, -1.0]])

    for i in range(data.shape[0]):
        print(f"Equation {i + 1}: {data[i][0]:.0f}x {data[i][1]:.0f}y {data[i][2]:.0f}z = {data[i][3]:.0f}")

    xyz = find_xyz(data)
    print(f"\nX = {xyz[0]}, Y = {xyz[1]}, Z = {xyz[2]}")

def find_xyz(data):
    arr = gaussian(data)
    xyz = [0, 0, 0]
    xyz[2] = int(arr[2][3] / arr[2][2])
    xyz[1] = int((arr[1][3] - (xyz[2] * arr[1][2])) / arr[1][1])
    xyz[0] = int((arr[0][3] - ((xyz[2] * arr[0][2]) + (xyz[1] * arr[0][1]))) / arr[0][0])
    return xyz

def gaussian(data):
    print("=== Before Gaussian ===")
    print_array(data)
    
    for i in range(data.shape[0]):
        main = data[i][i]
        for j in range(data.shape[0]):
            if j > i:
                sub = data[j][i]
                for k in range(data.shape[1]):
                    data[j][k] = (data[j][k] - (sub / main) * data[i][k]) * main

    print("\n=== After Gaussian ===")
    print_array(data)
    return data

def print_array(data):
    for row in data:
        print(row)

if __name__ == "__main__":
    main()
